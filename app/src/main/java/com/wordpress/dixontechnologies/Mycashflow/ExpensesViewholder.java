package com.wordpress.dixontechnologies.Mycashflow;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.wordpress.dixontechnologies.Mycashflow.data.DBAdapter;

import org.w3c.dom.Text;

import java.security.SecureRandom;

public class ExpensesViewholder extends  RecyclerView.ViewHolder {
    private static final int ACTIVITY_EXP_DETAILS = 1;
     TextView exp_item;
   TextView exp_cost;

    private TextView exp_id;
  TextView exp_time;
    final ImageView c_pop;
  /*  Context cv;
    private Cursor cmfCusor;
    int pos*/


    public ExpensesViewholder( View itemView ) {
        super(itemView);
        SecureRandom secureRandom = new SecureRandom();
        byte aByte[] = new byte[20];
        secureRandom.nextBytes(aByte);
        exp_item = itemView.findViewById(R.id.exp_item_name);
        exp_cost = itemView.findViewById(R.id.exp_item_cost);
        exp_id = itemView.findViewById(R.id.exp_id);
        exp_time = itemView.findViewById(R.id.exp_time);
        c_pop = itemView.findViewById(R.id.pop_up_2);



        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                openExp_details();

            }
        });


    }
//
//    private void openExp_details() {
//        Cursor c =cmfCusor;
//        c.moveToPosition(pos);
//        Intent i = new Intent(this, ExpDetails.class);
//        i.putExtra(Constants.KEY_ID, "");
//        i.putExtra(Constants.KEY_EXPENSES,
//                c.getString(c.getColumnIndexOrThrow(Constants.KEY_EXPENSES)));
//        i.putExtra(Constants.KEY_COST,
//                c.getString(c.getColumnIndexOrThrow(Constants.KEY_COST)));
//        i.putExtra(Constants.EXP_DATE,
//                c.getString(c.getColumnIndexOrThrow(Constants.EXP_DATE)));
//        startActivity(i, ACTIVITY_EXP_DETAILS);
//    }

}
