package com.wordpress.dixontechnologies.Mycashflow.data;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by DIXON on 7/15/2016.

 */

//updated on 8/5/2017
    /*
    this schema is like da=rth va=der
    */


public  class MyDBHelper extends SQLiteOpenHelper {

    private static final String TAG =  "is the database present?";

    private static MyDBHelper sInstance;

    static synchronized MyDBHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new MyDBHelper(context.getApplicationContext());
        }
        return sInstance;
    }

   public MyDBHelper(Context context) {
        super(context, Constants_.DATABASE_NAME, null, Constants_.DATABASE_VERSION);
        // return;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

            db.execSQL(CREATE_TABLE_CASH);
            db.execSQL(CREATE_TABLE_EXPENSES);
/*
        Log.d(TAG,"database created");
*/
    }

    //this snippet creates the cash table
    private static final String CREATE_TABLE_CASH = "create table " + Constants_.TABLE_CASH +
            " (" + Constants_.KEY_ID + " INTEGER PRIMARY KEY," + Constants_.KEY_CASH
             + " text not null," + Constants_.KEY_AMOUNT + " text not null,"  +
            Constants_.DATE_NAME + " INTEGER not null);";



  private static final String CREATE_TABLE_EXPENSES = "create table " + Constants_.TABLE_EXP +
            " (" + Constants_.EXP_KEY_ID + " INTEGER PRIMARY KEY," + Constants_.KEY_EXPENSES
             + " text not null," + Constants_.KEY_COST + " text not null,"  +
            Constants_.EXP_DATE + " INTEGER not null);";


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        Log.d("MyDBHelper ", "upgrading from version " +
                oldVersion + "to " + newVersion +
                ", which will destroy all the old data ");

        db.execSQL("DROP TABLE IF EXISTS " + Constants_.TABLE_CASH);
        db.execSQL("DROP TABLE IF EXISTS " + Constants_.TABLE_EXP);
        onCreate(db);
    }

/*
    public class getInstance extends MyDBHelper {
        public getInstance(Context c) {
            super(c);
        }
    }*/
}
