package com.wordpress.dixontechnologies.Mycashflow;

import android.app.ActionBar;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;



public class ViewAd extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen__ad_);

        Toolbar toolbar = findViewById(R.id.toolbar2);
        toolbar.setTitleTextColor(getResources().getColor(R.color.whiteTextColor));
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.md_nav_back);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);

        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


    private void loadAd() {

    /*    adRequestr = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequestr);
        if (interstitialAd.isLoaded()){

        }*/

    }


    public boolean isInternetAvailable(View view){
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        if (networkInfo != null){
            Snackbar.make(view,"no internet connection", Snackbar.LENGTH_LONG).setAction("Try Again", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        isInternetAvailable(view);
                }
            });
        }


        return networkInfo != null && networkInfo.isConnected();

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.refresh_btn :
                    loadAd();
                    isInternetAvailable(view);
            break;
        }



    }
}



