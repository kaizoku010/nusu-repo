/*
 * Copyright (c) $November 18th.2019. Property Of Muneza Dixon.
 */

package com.wordpress.dixontechnologies.Mycashflow;


import android.app.Dialog;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.wordpress.dixontechnologies.Mycashflow.data.Constants_;
import com.wordpress.dixontechnologies.Mycashflow.data.DBAdapter;
import com.wordpress.dixontechnologies.Mycashflow.listeners.RichListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;

/**
 * Created by DIXON on 9/20/2016.
 */


public class Tab_1 extends Fragment implements ItemRemovedListener {

    //Tab_1 is like subject x, all tests on tabs are handled here...the cash tab

    private static final String TAB_POSITION = "tab_position";
    ArrayList<Entry_Nusu_Ojo> mainEntries = new ArrayList<>();
    RVAdapter adapter;
    private RecyclerView recyclerView;
    private View v;
    private DBAdapter db;
    private ImageView emptyView;
    private TextView swipe_text;
    Entry_Nusu_Ojo entry_nusu_ojo;
    private SharedPreferences sharedPreferences;


    public static Tab_1 newInstance(int tabPosition) {
        Tab_1 fragment = new Tab_1();
        Bundle args = new Bundle();
        args.putInt(Tab_1.TAB_POSITION, tabPosition);
        fragment.setArguments(args);
        return fragment;


    }


    @Override
    public void onDestroy() {

        super.onDestroy();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*  NusuViewModel nusuViewModel = ViewModelProviders.of(this).get(NusuViewModel.class);
        mainEntries = nusuViewModel.getinsertCashLiveData()
*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.tab_1, container, false);
        adapter = new RVAdapter(getContext(), mainEntries);
        entry_nusu_ojo = new Entry_Nusu_Ojo();
        emptyView = v.findViewById(R.id.empty_view_cash);
        //cash_refreshlaRefreshLayout = v.findViewById(R.id.swipe_cash);
        recyclerView_and_all_OS();
        setUPviews();
        setCashValues();

        return v;
    }


    private void setCashValues() {
        db = new DBAdapter(getContext());
        mainEntries.clear();
        db.openDB();
        Cursor c = db.retrieve();
        if (c.moveToLast()) {

            do {
                //exp values from the database
                int id2 = c.getInt(c.getColumnIndex(Constants_.KEY_ID));
                String cas_Item = c.getString(c.getColumnIndex(Constants_.KEY_CASH));
                String costs_ = c.getString(c.getColumnIndex(Constants_.KEY_AMOUNT));
                DateFormat dateFormat2 = DateFormat.getDateTimeInstance();
                String exp_time =
                        dateFormat2.format
                                (new Date(c.getLong(c.getColumnIndex(Constants_.DATE_NAME))).getTime());


                entry_nusu_ojo = new Entry_Nusu_Ojo();

                entry_nusu_ojo.setId(id2);
                entry_nusu_ojo.setCash(cas_Item);
                entry_nusu_ojo.setAmount(costs_);
                entry_nusu_ojo.setTime_date(exp_time);
                mainEntries.add(entry_nusu_ojo);
                db.closeDB();
                //  db.updateCashTable(entry_nusu_ojo);
            } while (c.moveToPrevious());

            db.closeDB();

            if (!(mainEntries.size() > 0)) {
                recyclerView.setAdapter(adapter);
                emptyView.setVisibility(View.GONE);
            }


        }

    }

    private void setUPviews() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String currency_type = sharedPreferences.getString("currency_", "");
        String currency = currency_type;


        /*swipeRefreshLayout = v.findViewById(R.id.cash_swipe_layout);*/

        swipe_text = v.findViewById(R.id.swipe_to_expenses);
        recyclerView.setAdapter(adapter);

        recyclerView.animate();


        adapter.setOnBottomReachedListeners(postion -> {
            recyclerView.setBottom(postion);
            recyclerView.smoothScrollToPosition(postion);

        });


        if (mainEntries.size() >= 0) {
            recyclerView.setVisibility(View.VISIBLE);
            //  may_items_xp.setVisibility(View.VISIBLE);
            recyclerView.setAdapter(adapter);
            emptyView.setVisibility(View.GONE);

        }

        //here, the tab1 number of items entered will be ...items entered
        //and we shall have a visible recycler view also

        if (mainEntries.size() >= 2) {
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setAdapter(adapter);

        } else if (mainEntries.size() <= 0) {
            recyclerView.setVisibility(View.GONE);
            recyclerView.setAdapter(adapter);
            emptyView.setVisibility(View.VISIBLE);
        }

        if (mainEntries.size() == 1) {
            recyclerView.setAdapter(adapter);
            emptyView.setVisibility(View.GONE);
        }

        DividerItemDecoration divider = new DividerItemDecoration(requireContext(), HORIZONTAL);
        recyclerView.addItemDecoration(divider);
/*

        recyclerView.setLongClickable(true);
        recyclerView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
            openDeleDialog(v.getId(), v);
                Snackbar.make(v, "Oi Dixo...Keep it real. God Bless", Snackbar.LENGTH_LONG).show();
            return true;
            }
        });

*/


    }

    private void openDeleDialog(final int id, View v) {
        //custom dialog look
        final ViewGroup viewGroup = v.findViewById(R.id.content);
        View dialogview = LayoutInflater.from(getContext()).inflate(R.layout.activity_detail, viewGroup, false);
        Button buttonRestOk = dialogview.findViewById(R.id.buttonOk);
        Button buttonRestNo = dialogview.findViewById(R.id.buttonNo);
        TextView textView = dialogview.findViewById(R.id.texttv);
        textView.setText("Are you sure?");
        final Dialog dialog = new Dialog(getContext());
        //  final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        dialog.getActionBar().hide();
        dialog.setContentView(dialogview);

        dialog.show();



        buttonRestNo.setOnClickListener(v1 -> dialog.cancel());
        buttonRestOk.setOnClickListener(v12 -> _delete_(id, v12));

    }

    private void _delete_(int id, View v) {

        db = new DBAdapter(getContext());
        db.openDB();
        db.delete(id);
        db.closeDB();
    }

    @Override
    public void onPause() {
        super.onPause();
        setCashValues();

    }



    @Override
    public void onResume() {
        super.onResume();
        adapter = new RVAdapter(getContext(), mainEntries);
        recyclerView.setAdapter(adapter);
        setUPviews();
        setCashValues();

    }

    private void recyclerView_and_all_OS() {
        recyclerView = v.findViewById(R.id.rv);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),
                2, GridLayoutManager.VERTICAL, false));

//        adapter.setOnItemRemovedListener(pos -> adapter.getItemId(pos));


    }

    @Override
    public void onItemRemovedListener(int pos) {
        recyclerView.getChildAt(pos);
    }


}

