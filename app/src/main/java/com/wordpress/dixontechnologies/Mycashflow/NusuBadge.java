package com.wordpress.dixontechnologies.Mycashflow;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class NusuBadge extends android.support.v7.widget.AppCompatTextView  {
    private View target;

    public NusuBadge(Context context, View target) {
        super(context);
        setUp(context, target);
    }

    private void setUp(Context context, View target) {
    this.target = target;
    }

    public void updateBadge(int badgeNumber){
        if (badgeNumber > 0) {
            target.setVisibility(View.VISIBLE);
            ((TextView) target).setText(Integer.toString(badgeNumber));

        }else {
            target.setVisibility(View.GONE);
        }
    }
}
