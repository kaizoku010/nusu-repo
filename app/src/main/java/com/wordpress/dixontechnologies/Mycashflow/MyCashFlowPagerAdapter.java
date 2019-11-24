/*
 * Copyright (c) $November 18th.2019. Property Of Muneza Dixon.
 */

package com.wordpress.dixontechnologies.Mycashflow;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.security.SecureRandom;

/**
 * Created by DIXON on 9/18/2016.
 */
class MyCashFlowPagerAdapter extends FragmentStatePagerAdapter {

    MyCashFlowPagerAdapter(FragmentManager fm) {
        super(fm);

    }
    /*   case 1:
                       return new NusuArc();*/
    @Override
    public Fragment getItem( int position ) {
       switch (position) {
           case 0:
               return Tab_1.newInstance(position);
           case 1:
               return NusuArc.newInstance(position);
           case 2:
               return Tab_2.newInstance(position);
           default:
               return null;
       }

}

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Cash";
            case 1:
                return "Info";
            case 2:
                return "Expenses";
            default:
                return null;
        }}
}
