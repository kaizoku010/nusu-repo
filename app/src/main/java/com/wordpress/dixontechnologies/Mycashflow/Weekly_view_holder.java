package com.wordpress.dixontechnologies.Mycashflow;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ${Dixon} on 3/12/2017.
 */
public class Weekly_view_holder extends RecyclerView.ViewHolder {

    TextView ntrytxt;
    TextView ntryTime;
    private TextView ntryamount;
//    TextView tv_id;


    public Weekly_view_holder(View itemView) {
        super(itemView);
        ntrytxt = itemView.findViewById(R.id.cash_weekly_item);
        ntryamount = itemView.findViewById(R.id.cash_weekly_amount);
        ntryTime = itemView.findViewById(R.id.cash_weekly_time);

    }
}
