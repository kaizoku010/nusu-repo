package com.wordpress.dixontechnologies.Mycashflow;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.fabiomsr.moneytextview.MoneyTextView;

import java.util.List;

public class NewExpHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView xpname, txt_letter;
    MoneyTextView xpcost;
    TextView xptime;
    ImageView xpAvatar, delete_exp_bin;
    ItemClickListener itemClickListener;
    List<String> stringList;
    RelativeLayout root_view_;
    CardView swipeLayout;
    View back_ally, front_ally;

    public NewExpHolder(final View itemview) {
        super(itemview);

        swipeLayout = itemview.findViewById(R.id.swipe_layout_exp);
        xpname = itemview.findViewById(R.id.item__exp);
        xpcost = itemview.findViewById(R.id.cost___);
        root_view_ = itemview.findViewById(R.id.holder_root_exp);
        txt_letter = itemview.findViewById(R.id.alpha_tv_exp);
        xptime = itemview.findViewById(R.id.time_exp);
        delete_exp_bin = itemview.findViewById(R.id.exp_bin);
    }


    @Override
    public void onClick(View view) {
       this.itemClickListener.onitemClick(view, getAdapterPosition());


    }

    public void setExpItemClickListener(ItemClickListener ic) {
        this.itemClickListener = ic;
    }
}



