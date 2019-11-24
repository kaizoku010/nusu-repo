package com.wordpress.dixontechnologies.Mycashflow;


import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.wordpress.dixontechnologies.Mycashflow.data.DBAdapter;

public class ExpContentProvider extends ContentProvider{

    public static final String Expense_PROVIDER_NAME
            = "com.wordpress.dixontechnologies.Mycashflow.expenses_flow_table";


    public static final Uri Expenses_CONTENT_URI
            = Uri.parse("content://" + Expense_PROVIDER_NAME +"/expenses_flow_table");

    private static final int Expenses_LOCATION = 1;

    private static final UriMatcher exp_uriMatcher;
    static {
        exp_uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        exp_uriMatcher.addURI(Expense_PROVIDER_NAME,"expenses_flow_table", Expenses_LOCATION);
    }
DBAdapter dbAdapter;


    public static final String PROVIDER_NAME
            = "com.wordpress.dixontechnologies.Mycashflow.expenses_flow_table";

    @Override
    public boolean onCreate() {
        dbAdapter = new DBAdapter(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        if (exp_uriMatcher.match(uri)== Expenses_LOCATION){
            return  dbAdapter.getallExp_locations();
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

     long rowID = dbAdapter.insertNew_exp(contentValues);
     Uri _uri = null;
     if (rowID > 0){
         _uri = ContentUris.withAppendedId(Expenses_CONTENT_URI,rowID);
     }else {
         try {
             throw new SQLException("failed to insert Expenses :" + uri);

         } catch (SQLException e) {
             e.printStackTrace();

         }
     }
        return _uri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
      int count = 0;
      count = dbAdapter.delExP();
        return count;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
