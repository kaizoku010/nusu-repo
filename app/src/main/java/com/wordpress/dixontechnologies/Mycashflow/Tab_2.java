package com.wordpress.dixontechnologies.Mycashflow;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.clans.fab.FloatingActionButton;
import com.wordpress.dixontechnologies.Mycashflow.data.Constants_;
import com.wordpress.dixontechnologies.Mycashflow.data.DBAdapter;
import com.wordpress.dixontechnologies.Mycashflow.listeners.RichListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;

/**
 * Created by DIXON on 9/20/2016.
 */
public class Tab_2 extends Fragment implements RichListener {
    private static final String TAB_POSITION = "tab_position";
    ArrayList<Entry_Nusu_Ojo> mainEntries = new ArrayList<>();
    private View v;
    private DBAdapter db;
    RichListener richListener;
    //   private TextView expRowCount, may_items_xp, one_item_xp;
    private ExpAdapter adapter;
    private FixedRecyclerView recyclerView;
    // private SwipeRefreshLayout exp_SwipeRefreshLayout;
    private FloatingActionButton sharedFab;
    private ImageView imageView;
    Entry_Nusu_Ojo entry_nusu_ojo;


    public static Tab_2 newInstance(int tabPosition) {
        Tab_2 fragment = new Tab_2();
        Bundle args = new Bundle();
        args.putInt(Tab_2.TAB_POSITION, tabPosition);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.tab_2, container, false);
        recyclerView = v.findViewById(R.id.rv2);
        imageView = v.findViewById(R.id.empty_view2);
        entry_nusu_ojo = new Entry_Nusu_Ojo();
        getExp_Entries();
        adapter = new ExpAdapter(getContext(), mainEntries);
        recyclerView.setAdapter(adapter);
        FixedRecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        assert animator != null;
        animator.setAddDuration(2000);
        animator.setRemoveDuration(100);
        recyclerView_morphing();
        //this can function here sucks data from the structured- query language(SQL), changes and display it all over the app
        emptyViews();
        return v;

    }

    private void emptyViews() {

        if (mainEntries.size() >= 0) {
            recyclerView.setVisibility(View.VISIBLE);
            //  may_items_xp.setVisibility(View.VISIBLE);
            recyclerView.setAdapter(adapter);
            imageView.setVisibility(View.GONE);

        }

        //here, the tab1 number of items entered will be ...items entered
        //and we shall have a visible recycler view also

        if (mainEntries.size() >= 2) {
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setAdapter(adapter);

        } else if (mainEntries.size() <= 0) {
            recyclerView.setVisibility(View.GONE);
            recyclerView.setAdapter(adapter);
            imageView.setVisibility(View.VISIBLE);
        }

        if (mainEntries.size() == 1) {
            recyclerView.setAdapter(adapter);
            imageView.setVisibility(View.GONE);
        }

        DividerItemDecoration divider = new DividerItemDecoration(requireContext(), HORIZONTAL);
        recyclerView.addItemDecoration(divider);

    }

    private void recyclerView_morphing() {

        recyclerView = v.findViewById(R.id.rv2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final LinearLayoutManager layoutManager =
                new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(new
                GridLayoutManager(getContext(),
                2, GridLayoutManager.VERTICAL, false));
       // adapter = new ExpAdapter(getActivity(), mainEntries);
        recyclerView.setAdapter(adapter);
        FixedRecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        animator.setAddDuration(2000);
        animator.setRemoveDuration(1000);


        adapter.setOnBottomReachedListeners_(new OnBottomReachedListener() {
            @Override
            public void onBottomReached(int postion) {

                recyclerView.setBottom(postion);
                recyclerView.smoothScrollToPosition(postion);

            }
        });
//        adapter.deleteEntriesEXP(adapter.getItem());

    }



    //out of Bounds meth
    private void getExp_Entries() {

        db = new DBAdapter(getContext());
        db.openDB();
        mainEntries.clear();
        Cursor c = db.retrieve_Expenses();


        if (c.moveToLast()) {

            do {
                //exp values from the database
                int id2 = c.getInt(c.getColumnIndex(Constants_.EXP_KEY_ID));
                String exp_Item = c.getString(c.getColumnIndex(Constants_.KEY_EXPENSES));
                String costs = c.getString(c.getColumnIndex(Constants_.KEY_COST));
                DateFormat dateFormat2 = DateFormat.getDateTimeInstance();
                String exp_time =
                        dateFormat2.format
                                (new Date(c.getLong(c.getColumnIndex(Constants_.EXP_DATE))).getTime());

                entry_nusu_ojo =    new Entry_Nusu_Ojo();

                entry_nusu_ojo.setExp_id(id2);
                entry_nusu_ojo.setexpenses(exp_Item);
                entry_nusu_ojo.setCost(costs);
                entry_nusu_ojo.setExp_date(exp_time);
                mainEntries.add(entry_nusu_ojo);

            } while (c.moveToPrevious());

            db.closeDB();
            if (!(mainEntries.size() > 0)) {
                recyclerView.setAdapter(adapter);
                imageView.setVisibility(View.GONE);

            }


        }

    }

    @Override
    public void updateUi(DBAdapter nusu_ojo) {
        this.db = nusu_ojo;
        
    }
}