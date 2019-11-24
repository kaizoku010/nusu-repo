package com.wordpress.dixontechnologies.Mycashflow;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by DIXON on 11/5/2016.
 */
class About_pagerAdapter extends FragmentStatePagerAdapter {

    public About_pagerAdapter( FragmentManager fm ) {
        super(fm);
    }

    @Override
    public Fragment getItem( int position ) {
        switch (position) {
            case 0:
                return new About_frag();
            case 1 :
                return new Policy_frag();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
