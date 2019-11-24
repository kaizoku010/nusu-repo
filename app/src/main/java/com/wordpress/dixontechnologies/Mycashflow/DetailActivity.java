/*
package com.wordpress.dixontechnologies.Mycashflow;

import android.app.Activity;
import android.app.NotificationChannel;
import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.wordpress.dixontechnologies.Mycashflow.data.DBAdapter;

import java.util.ArrayList;


public class DetailActivity extends AppCompatActivity {



    @Override
    public boolean onNavigateUpFromChild(Activity child) {
        return super.onNavigateUpFromChild(child);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        savedInstanceState.getBundle("_id");
        setContentView(R.layout.activity_detail);
*/
/*
       Button btn_delete_ =findViewById(R.id.btn_delete);


        TextView id_ = findViewById(R.id.idcash);
        TextView item_ =  findViewById(R.id.item_txt);
        TextView  amount_ =  findViewById(R.id._amount);
        TextView  date_ =  findViewById(R.id._date);
     //   TextView  location_name = findViewById(R.id.loc_);*//*


        Intent intent = getIntent();

       int type = 0;

       switch (type){
           case 0:
               intent.getBundleExtra("_id");
               intent.getBundleExtra("cash_item");
               intent.getBundleExtra("cash_amount");
               intent.getBundleExtra("cash_time");
               intent.getFlags();

               //int id = intent.getStringExtra("_id");
               String item = intent.getStringExtra("cash_item");
               String amount = intent.getStringExtra("cash_amount");
               String time_date = intent.getStringExtra("cash_time");
               final int position = intent.getIntExtra("position",0);

               id_.setText("Position works!!!"+position);
               item_.setText("Item: "+item);
               amount_.setText("Amount: "+amount);
               date_.setText("TimeDate: "+time_date);


       break;
           case 1:
             intent.getBundleExtra("x_id");
             intent.getBundleExtra("x_type");
             intent.getBundleExtra("x_cost");
             intent.getBundleExtra("x_time");
             String exp_id = intent.getStringExtra("x_id");
             String exp_item = intent.getStringExtra("x_type");
             String exp_amount = intent.getStringExtra("x_cost");
             String exp_time = intent.getStringExtra("x_time");
             id_.setText("Id"+ exp_id );
             item_.setText("Expenses" + exp_item);
             amount_.setText("Cost" + exp_amount);
             date_.setText(exp_time);
             break;


       }




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
*/
