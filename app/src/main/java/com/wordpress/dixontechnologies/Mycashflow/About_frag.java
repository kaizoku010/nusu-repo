package com.wordpress.dixontechnologies.Mycashflow;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by ${Dixon} on 11/5/2016.
 */
public class About_frag extends Fragment  {

    private Context c;
    ImageView facebook_page,twitter_page;
    PackageManager pm;
    String url;
    View v;
    private static final String ARG_LAYOUT_RES_ID = "layoutResId";
    private int layoutId;

    public static About_frag newInstance(int layoutId){
        About_frag about_frag = new About_frag();
        Bundle args = new Bundle();
        args.putInt(ARG_LAYOUT_RES_ID, layoutId);
        return about_frag;
    }

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

        if (getArguments() != null && getArguments().containsKey(ARG_LAYOUT_RES_ID)){
            layoutId = getArguments().getInt(ARG_LAYOUT_RES_ID);
        }



    }


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
       v = inflater.inflate(R.layout.about_frag, container, false);

        twitter_page = v.findViewById(R.id.twitter_page_);
        twitter_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opening_our_twitter_page();
            }
        });

        facebook_page = v.findViewById(R.id.fb_page);
        facebook_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opening_our_fb_page();



            }
        });


        return v;
          }


    //opening our the facebook page
    private void opening_our_fb_page() {

        Intent facabookPage = getOpenFacebookIntent(getContext());
        startActivity(facabookPage);



    }

    private Intent getOpenFacebookIntent(Context about_frag) {
        try{
            about_frag.getPackageManager().
                    getPackageInfo("com.facebook.katana/nusuApp", 0);
            return  new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://profile/nusuApp"));
        } catch (PackageManager.NameNotFoundException e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/nusuApp"));

        }

    }


    //opening the twitter page
    private void opening_our_twitter_page() {

        try {
            Intent twitter_intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("twitter://user?screen_name=[MyCashFlow5]"));
            startActivity(twitter_intent);
        } catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://twitter.com/#!/[MyCashFlow5]")));
            e.printStackTrace();
        }
    }


}
