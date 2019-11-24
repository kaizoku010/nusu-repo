package com.wordpress.dixontechnologies.Mycashflow;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by DIXON on 11/5/2016.
 */
public class Policy_frag extends Fragment {

    Context c;


    @Override
    public void setArguments( Bundle args ) {
        super.setArguments(args);
    }


    @Override
    public void onSaveInstanceState( Bundle outState ) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
        View v = inflater.inflate(R.layout.policy_frag, container, false);
       /*policy_adview = (AdView) v.findViewById(R.id.adView_privacy);
        AdRequest privacy_adRequest = new AdRequest.Builder()
                .build();
        policy_adview.loadAd(privacy_adRequest);
*/

        return v;
    }


}
