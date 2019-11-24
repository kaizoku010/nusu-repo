/*
package com.wordpress.dixontechnologies.Mycashflow;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

*/
/**
 * Created by ${Dixon} on 3/12/2017.
 *//*

class Weekly_rvAdapter extends RecyclerView.Adapter<Weekly_view_holder>{

    private Context c;
    private ArrayList<Entry_Nusu_Ojo> main_entries = new ArrayList<>();
    private View v;


    public Weekly_rvAdapter(Context context, ArrayList entries){
        this.c = context;
        main_entries = entries;

    }

    @Override
    public Weekly_view_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.weekly_item_holder, parent, false);

        return null;
    }

    @Override
    public void onBindViewHolder(Weekly_view_holder holder, int position) {
        Entry_Nusu_Ojo weekly_cash_values = main_entries.get(position);

        holder.ntrytxt.setText(weekly_cash_values.getCash());
       // holder.ntryamount.setText(weekly_cash_values.getAmount(cursor.getString(2)));
        holder.ntryTime.setText(weekly_cash_values.getExp_date());
    }

    @Override
    public int getItemCount() {
        return main_entries.size();
    }
}
*/
