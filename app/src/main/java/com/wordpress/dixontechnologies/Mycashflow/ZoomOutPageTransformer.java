package com.wordpress.dixontechnologies.Mycashflow;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

class ZoomOutPageTransformer implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;


    @Override
    public void transformPage(@NonNull View view, float v) {
            int pageWide = view.getWidth();
            int pageLong = view.getHeight();


            if (v <-1){
                //infinity..when page is off the screen.
                view.setAlpha(0f);
            } else if (v <= 1){
                //modify the default slides transition to shrink page.
                float scaleFac = Math.max(MIN_SCALE, 1 - Math.abs(v));
                float verticMargin = pageLong * (1 -scaleFac)/2;
                float horizontalMArgin = pageWide * (1-scaleFac)/2;

                if (v < 0) {
                    view.setTranslationX(horizontalMArgin - verticMargin/2);
                } else {
                    view.setTranslationY(-horizontalMArgin + verticMargin/2);
                }
                //scale the page down btn min_scale & 1
                view.setScaleX(scaleFac);
                view.setScaleY(scaleFac);
                //fade page accor to its size
                view.setAlpha(MIN_ALPHA + (scaleFac - MIN_SCALE) /
                        (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else {
                //infinity
                //like way off to the right
                view.setAlpha(0f);
            }
    }
}
