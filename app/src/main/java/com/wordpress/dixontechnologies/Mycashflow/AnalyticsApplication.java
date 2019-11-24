//package com.wordpress.dixontechnologies.Mycashflow;
//
//import android.app.Application;
//
//import com.google.android.gms.analytics.GoogleAnalytics;
//import com.google.android.gms.analytics.Tracker;
//
///**
// * Created by DIXON on 11/21/2016.
// */
//public class AnalyticsApplication extends Application {
//    Tracker mTracker;
//
//    synchronized public Tracker getTracker(){
//        if (mTracker == null){
//            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
//            mTracker = analytics.newTracker(R.xml.app_tracker);
//
//        }
//    return mTracker;
//    }
//}
