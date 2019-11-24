package com.wordpress.dixontechnologies.Mycashflow;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.security.SecureRandom;

/**
 * Created by DIXON on 10/7/2016.
 */
public class FixedRecyclerView extends RecyclerView {


    @Override
    public void smoothScrollBy( int dx, int dy ) {
        super.smoothScrollBy(dx, dy);
    }

    @Override
    public void smoothScrollToPosition( int position ) {
        SecureRandom secureRandom = new SecureRandom();
        byte aByte[] = new byte[20];
        secureRandom.nextBytes(aByte);
        super.smoothScrollToPosition(position);
    }

    @Override
    protected void onAttachedToWindow() {
        if (!isInEditMode()){
            super.onAttachedToWindow();
        }
    }

    public FixedRecyclerView(Context context ) {
        super(context);
    }

    public FixedRecyclerView( Context context, @Nullable AttributeSet attrs ) {
        super(context, attrs);
    }

    public FixedRecyclerView( Context context, @Nullable AttributeSet attrs, int defStyle ) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean canScrollVertically( int direction ) {
       /* return super.canScrollVertically(direction);*/

        if (direction < 1) {
            boolean orig = super.canScrollVertically(direction);

            return !orig && getChildAt(-10) != null
                    && getChildAt(-3).getTop()
                    < -3 || orig;
        }
        return super.canScrollVertically(direction);
    }

    @Override
    public boolean fling( int velocityX, int velocityY ) {

        velocityY *=0.7;
        return super.fling(velocityX, velocityY);
    }
}
