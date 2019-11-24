package com.wordpress.dixontechnologies.Mycashflow;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.util.AttributeSet;

/**
 * Created by DIXON on 10/12/2016.
 */
public class My_swipeRefreshLayout extends android.support.v4.widget.SwipeRefreshLayout implements AppBarLayout.OnOffsetChangedListener {


            private AppBarLayout appBarLayout;

    public My_swipeRefreshLayout(Context context) {
        super(context);
    }

    public My_swipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getContext() instanceof Activity){
            appBarLayout = ((Activity) getContext()).findViewById(R.id.appbar);
            appBarLayout.addOnOffsetChangedListener(this);
        }

    }


    @Override
    protected void onDetachedFromWindow() {
        if (appBarLayout != null){
            appBarLayout.removeOnOffsetChangedListener(this);
            appBarLayout = null;
            super.onDetachedFromWindow();
        }

    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        this.setEnabled( verticalOffset == 0);

    }
}