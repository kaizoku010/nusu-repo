package com.wordpress.dixontechnologies.Mycashflow;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

import java.security.SecureRandom;

/**
 * Created by DIXON on 9/27/2016.
 */
class SwipeDismissListViewTouchListener implements View.OnTouchListener
{

    // Cached ViewConfiguration and system-wide constant values
    private int mSlop;
    private int mMinFlingVelocity;
    private int mMaxFlingVelocity;
    private long mAnimationTime;

    // Fixed properties
    private View mView;
    private DismissCallbacks mCallbacks;
    private int mViewWidth = 1; // 1 and not 0 to prevent dividing by zero

    // Transient properties
    private float mDownX;
    private float mDownY;
    private boolean mSwiping;
    private int mSwipingSlop;
    private Object mToken;
    private VelocityTracker mVelocityTracker;
    private float mTranslationX;

    @Override
    public boolean onTouch( View v, MotionEvent event ) {
        return false;
    }

    public interface DismissCallbacks {
      /*  SecureRandom secureRandom = new SecureRandom();
        byte aByte[] = new byte[20];
        secureRandom.nextBytes(aByte);*/


    }


}
