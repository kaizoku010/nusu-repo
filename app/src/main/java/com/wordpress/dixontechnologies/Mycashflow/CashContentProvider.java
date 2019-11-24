/*
package com.wordpress.dixontechnologies.Mycashflow;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.wordpress.dixontechnologies.Mycashflow.data.DBAdapter;



*/
/**
 * Created by ${Dixon} on 10/19/2018.
 *//*

public class CashContentProvider extends ContentProvider {

    public static final String PROVIDER_NAME =
            "com.wordpress.dixontechnologies.Mycashflow.cash_flow_table";

    public static final Uri C_CONTENT_URI = Uri.parse("content://"
    + PROVIDER_NAME + "/cash_flow_table");

    private static final int LOCATIONS = 1;

    private static final UriMatcher uriMatcher ;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "cash_flow_table", LOCATIONS);
    }


        DBAdapter dbAdapter;




    @Override
    public boolean onCreate() {
        dbAdapter = new DBAdapter(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {

        if (uriMatcher.match(uri) == LOCATIONS){
            return  dbAdapter.getAllLOcations();
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        long rowID = dbAdapter.insertCash_LatLng(contentValues);
        Uri _uri = null;
        if (rowID > 0) {

            _uri = ContentUris.withAppendedId(C_CONTENT_URI, rowID);
        } else {
            try {
                throw new SQLException(" failed to save : " + uri);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return _uri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
       int count = 0;
       count = dbAdapter.del();
       return count;

    }



    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }



}
*/
