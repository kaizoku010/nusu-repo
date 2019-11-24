package com.wordpress.dixontechnologies.Mycashflow;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import org.fabiomsr.moneytextview.MoneyTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${Dixon} on 5/8/2018.
 */

public class NewCashHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {


 //   ImageView delete_bin;
    TextView item_name, letter_tv ;
 //   View layout_one, layout2;
    MoneyTextView amount_;
    TextView time, undo, month_date;
 //   TextView icon_text;
    private ItemClickListener itemClickListener;
    //Context context_;
   // NusuSwipeLayout swipe_lay;
  //  ImageView root_view;
    RelativeLayout root_view;



    NewCashHolder(View itemView) {
        super(itemView);
        item_name = itemView.findViewById(R.id.item__);
        amount_ = itemView.findViewById(R.id.amount___);
        time = itemView.findViewById(R.id.time_);
        letter_tv = itemView.findViewById(R.id.alpha_tv);
        root_view = itemView.findViewById(R.id.holder_root);

       itemView.setOnLongClickListener(this);
       itemView.setOnClickListener(this);

    }


    void setLongItemClickListener(ItemClickListener ic){
        this.itemClickListener = ic;
    }

    @Override
    public boolean onLongClick(View v) {
        this.itemClickListener.onitemClick(v, getAdapterPosition());
      //  Snackbar.make(v, "longclick", Snackbar.LENGTH_LONG).show();
        return true;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onitemClick(v, getAdapterPosition());
       // Snackbar.make(v, "Hold to delete item", Snackbar.LENGTH_LONG).show();

    }

    public void setItemClickListener(ItemClickListener worrkkksssss) {
        this.itemClickListener = worrkkksssss;
    }
}