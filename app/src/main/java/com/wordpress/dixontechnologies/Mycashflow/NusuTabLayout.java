package com.wordpress.dixontechnologies.Mycashflow;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.transition.TransitionManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class NusuTabLayout extends TabLayout {

        protected ColorStateList badgeBackgroundColors;
        protected ColorStateList badgeTextColors;
        protected float badgeTextSize = 0.0F;

        public NusuTabLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.badgeBackgroundColors = ContextCompat.getColorStateList(context, R.color.colorPrimaryDark);
            TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.nusuTabLayout, 0, 0);
            this.badgeTextColors = this.getContextColors();

            try {
                if (a.hasValue(R.styleable.nusuTabLayout_nusu_BadgeBackgroundColor)) {
                    this.badgeBackgroundColors = a.getColorStateList(R.styleable.nusuTabLayout_nusu_BadgeBackgroundColor);
                }

                if (a.hasValue(R.styleable.nusuTabLayout_nusu_BadgeBackgroundColor)) {
                    this.badgeTextColors = a.getColorStateList(R.styleable.nusuTabLayout_nusu_BadgeBackgroundColor);
                }

                if (a.hasValue(R.styleable.nusuTabLayout_nusu_BadgeTextSize)) {
                    this.badgeTextSize = a.getDimension(R.styleable.nusuTabLayout_nusu_BadgeTextSize, 0.0F);
                }

                int selected;
                if (a.hasValue(R.styleable.nusuTabLayout_nusu_BadgeSelectedBackgroundColor)) {
                    selected = a.getColor(R.styleable.nusuTabLayout_nusu_BadgeBackgroundColor, 0);
                    this.badgeBackgroundColors = createColorStateList(this.badgeBackgroundColors.getDefaultColor(), selected);
                }

                if (a.hasValue(R.styleable.nusuTabLayout_nusu_BadgeSelectedTextColor)) {
                    selected = a.getColor(R.styleable.nusuTabLayout_nusu_BadgeSelectedTextColor, 0);
                    this.badgeTextColors = createColorStateList(this.badgeTextColors.getDefaultColor(), selected);
                }
            } finally {
                a.recycle();
            }

        }

        public ColorStateList getBadgeBackgroundColors() {
            return this.badgeBackgroundColors;
        }

        public float getBadgeTextSize() {
            return this.badgeTextSize;
        }

        public void setBadgeTextSize(float badgeTextSize) {
            this.badgeTextSize = badgeTextSize;
        }

        public void setBadgeBackgroundColors(ColorStateList badgeBackgroundColors) {
            this.badgeBackgroundColors = badgeBackgroundColors;
            this.updateTabViews();
        }

        public ColorStateList getBadgeTextColors() {
            return this.badgeTextColors;
        }

        public void setBadgeTextColors(ColorStateList badgeTextColors) {
            this.badgeTextColors = badgeTextColors;
            this.updateTabViews();
        }

        public void addTab(@NonNull Tab tab, int position, boolean setSelected) {
            super.addTab(tab, position, setSelected);
            this.onTabAdded(tab);
        }

        public void updateTabViews() {
            for(int i = 0; i < this.getTabCount(); ++i) {
                Tab tab = this.getTabAt(i);
                if (tab != null) {
                    tab.setCustomView(this.makeCustomView(tab, R.layout.custom_badge));
                }
            }

        }

        private View makeCustomView(Tab tab, int resId) {
            LayoutInflater inflater = LayoutInflater.from(this.getContext());
            View view = inflater.inflate(resId, null);
            TextView title = view.findViewById(R.id.textview_tab_title);
            title.setTextColor(this.getTabTextColors());
            title.setText(tab.getText());
            TextView badge = view.findViewById(R.id.textview_tab_badge);
            badge.setTextColor(this.badgeTextColors);
            if (this.badgeTextSize != 0.0F) {
                badge.setTextSize(0, this.badgeTextSize);
            }

            DrawableCompat.setTintList(badge.getBackground(), this.badgeBackgroundColors);
            return view;
        }

        public void setBadgeText(int index, @Nullable String text) {
            Tab tab = this.getTabAt(index);
            if (tab != null && tab.getCustomView() != null) {
                TextView badge = tab.getCustomView().findViewById(R.id.textview_tab_badge);
                TextView tabText = tab.getCustomView().findViewById(R.id.textview_tab_title);
                if (text == null) {
                    badge.setVisibility(VISIBLE);
                    tabText.setMaxWidth(2147483647);
                } else {
                    int maxWidth = this.getResources().getDimensionPixelSize(com.wordpress.dixontechnologies.Mycashflow.R.dimen.tab_text_max_width);
                    badge.setText(text);
                    tabText.setMaxWidth(maxWidth);
                    badge.setVisibility(INVISIBLE);
                }

                TransitionManager.beginDelayedTransition((ViewGroup)tab.getCustomView());
            } else {
                Log.e("BadgedTabLayout", "Tab is null. Not setting custom view");
            }
        }

        public void onTabAdded(Tab tab) {
            if (tab == null) {
                Log.e("BadgedTabLayout", "Tab is null. Not setting custom view");
            } else {
                tab.setCustomView(this.makeCustomView(tab, R.layout.nusu_badge));
            }
        }

        private ColorStateList getContextColors() {
            TypedValue typedValue = new TypedValue();
            TypedArray a = this.getContext().obtainStyledAttributes(typedValue.data, new int[]{R.attr.colorPrimary,
                   R.attr.colorPrimaryDark});
            int primaryColor = a.getColor(0, 0);
            int primaryDarkColor = a.getColor(1, 0);
            a.recycle();
            return createColorStateList(primaryDarkColor, primaryColor);
        }

        private static ColorStateList createColorStateList(int defaultColor, int selectedColor) {
            int[][] states = new int[2][];
            int[] colors = new int[2];
            int i_ = 0;
            states[i_] = SELECTED_STATE_SET;
            colors[i_] = selectedColor;
            int i = i_ + 1;
            states[i] = EMPTY_STATE_SET;
            colors[i] = defaultColor;
            ++i;
            return new ColorStateList(states, colors);
        }
    }


