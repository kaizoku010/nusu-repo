//package com.wordpress.dixontechnologies.Mycashflow;
//
//import android.app.ActionBar;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.support.v4.app.NavUtils;
//import android.support.v4.app.TaskStackBuilder;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.util.Log;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//
//
////import com.google.android.gms.analytics.GoogleAnalytics;
////import com.google.android.gms.analytics.HitBuilders;
////import com.google.android.gms.analytics.Tracker;
//
//
//public class Upgrade_page extends AppCompatActivity {
//
//    //we have two types of ads in the upgrade activity, the interstitial ads and a banner;
//
//    private ImageView back_up_g;
//    private Button view_full_ad_btn;
//    private Button feed_back;
//    private String TAG = Upgrade_page.class.getSimpleName();
////    private Tracker mTracker;
//
//    public static final String email = "dixontheworldvsy@gmail.com";
//
//  //InterstitialAd interstitialAd;
//
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_upgrade_page);
//
//
//        final ActionBar actionBar = getActionBar();
//        assert actionBar != null;
//     //   actionBar.setDisplayHomeAsUpEnabled(true);
//
////        AnalyticsApplication application = (AnalyticsApplication) getApplication();
////        mTracker = application.getTracker();
//
//
//
//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        if (toolbar != null) {
//            toolbar.getNavigationIcon();
//        }
//        back_up_g = (ImageView) findViewById(R.id.back_upgrade);
//        //the interstitial ad
//        view_full_ad_btn = (Button) findViewById(R.id.open_full_ad);
//        //this is the banner
////        remove_ads_btn = (Button) findViewById(R.id.remove_ads);
//        feed_back = (Button) findViewById(R.id.feedback_btn);
//
//
//        openVideoAd();
//
//        feed_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                open_feed_back();
//            }
//        });
//      back_up_g.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
//
//        }
//
//    private void openVideoAd() {
//
//
//
//        view_full_ad_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                Intent intent = new Intent(Upgrade_page.this, ViewAd.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//    private void open_feed_back() {
//
//        Log.i("send email", "");
//        String[] TO ={email};
//        String[] cc = {""};
//        Intent email_intent = new Intent(Intent.ACTION_SEND);
//        email_intent.setData(Uri.parse("dixon:"));
//        email_intent.setType("text/plain");
//        email_intent.putExtra(Intent.EXTRA_EMAIL, TO );
//        email_intent.putExtra(Intent.EXTRA_CC, cc );
//        email_intent.putExtra(Intent.EXTRA_SUBJECT, "McF ENQUIRY");
//        email_intent.putExtra(Intent.EXTRA_TEXT, "Email goes here..");
//
//        startActivity(Intent.createChooser(email_intent, "send mail..."));
//            finish();
//    }
//
//
//    // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                Intent upIntent = new Intent(this, HomeScreen.class);
//                if (NavUtils.shouldUpRecreateTask(this, upIntent)){
//                    TaskStackBuilder.from(this).addNextIntent(upIntent).startActivities();
//                    finish();
//                } else {
//                    NavUtils.navigateUpTo(this, upIntent);
//                }
//                return true;
//
//        }
//return super.onOptionsItemSelected(item);
//    }
//
//}
