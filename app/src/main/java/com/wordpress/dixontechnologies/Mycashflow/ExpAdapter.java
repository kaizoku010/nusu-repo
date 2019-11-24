package com.wordpress.dixontechnologies.Mycashflow;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wordpress.dixontechnologies.Mycashflow.data.DBAdapter;
import com.wordpress.dixontechnologies.Mycashflow.listeners.RichListener;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by DIXON on 9/16/2016.
 */
public class ExpAdapter extends RecyclerView.Adapter<NewExpHolder> {

    ArrayList<Entry_Nusu_Ojo> main_entries;
    OnBottomReachedListener onBottomReachedListener;
    ItemClickListener itemClickListener;
    private Context context;
    private DBAdapter db;
    private RichListener richListener;
    private View v;

    private SharedPreferences pref;
    private Entry_Nusu_Ojo entryNusuOjo_delete;

    ExpAdapter(Context c, ArrayList<Entry_Nusu_Ojo> main_entries) {

        db = new DBAdapter(c);
        this.context = c;
        this.main_entries = main_entries;
        this.richListener = new RichListener() {
            @Override
            public void updateUi(DBAdapter nusu_ojo) {
                db = nusu_ojo;
            }
        };
    }


    @NonNull
    @Override
    public NewExpHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.exp_test_layout, viewGroup, false);

        return new NewExpHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull final NewExpHolder holder, int position) {


        final int pos = holder.getAdapterPosition();
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        String money_sign = pref.getString("currency_", "");
        String letter = main_entries.get(pos).getexpenses().substring(0, 1).toUpperCase();

        holder.xpname.setText(main_entries.get(pos).getexpenses());
        holder.xpcost.setAmount(Float.valueOf(main_entries.get(pos).getCost()), money_sign);
        String date_time = String.valueOf(main_entries.get(pos).getExp_date());
        holder.xptime.setText(date_time);
        holder.txt_letter.setText(letter);


        NusuColorGen colorGenerator = NusuColorGen.DEFAULT;
        int color = colorGenerator.getColor(main_entries.get(pos).getExp_id());
        holder.txt_letter.setText(letter);

        CircularTextLogo circularTextLogo = new CircularTextLogo.uilder().buildRect("", color);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            holder.root_view_.setBackground(circularTextLogo);
        }
        holder.root_view_.setBackground(circularTextLogo);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Hold to delete", Snackbar.LENGTH_LONG).show();

            }
        });



        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                deleteEntriesEXP(holder.getAdapterPosition(), v);
                return true;
            }
        });

    }


    private void deleteEntriesEXP(final int pos, final View view) {

        new AlertDialog.Builder(context)
                .setTitle("Delete Item")
                .setMessage("Are you sure ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteDbData(view, pos);
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
        this.notifyItemRemoved(pos);
        this.notifyDataSetChanged();

    }

    private void deleteDbData(View view, final int pos) {
        entryNusuOjo_delete = main_entries.get(pos);
        int id = entryNusuOjo_delete.getId();
        db = new DBAdapter(context);
        db.openDB();
        if (db.delete_exp(id)){
            main_entries.remove(pos);
            notifyItemRemoved(pos);
            getItemCount();
            Snackbar.make(view, "Item deleted", Snackbar.LENGTH_LONG).setAction("Refresh", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        getItemCount();
                        db = new DBAdapter(context);
                        db.openDB();
                        db.retrieve();
                        db.getTotalExpenses();
                        db.getTotalCash();
                        db.retrieve_Expenses();
                        db.closeDB();

                        notifyItemRemoved(pos);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).show();
        } else {
            Snackbar.make(view, "Unable To Delete, consult developer", Snackbar.LENGTH_SHORT).show();
        }
        db.closeDB();



    }


    @Override
    public int getItemCount() {
        TextView textView = new TextView(context);
        if (main_entries.size() == 0) {

            textView.setText(R.string.empty_view);
            textView.setVisibility(View.VISIBLE);

        } else if (main_entries.size() != 0) {
            textView.setVisibility(View.INVISIBLE);
        }

        return main_entries.size();
    }//deleteEntriesEXP



    public void setOnBottomReachedListeners_(OnBottomReachedListener onBottomReachedListener) {
        this.onBottomReachedListener = onBottomReachedListener;

    }
}