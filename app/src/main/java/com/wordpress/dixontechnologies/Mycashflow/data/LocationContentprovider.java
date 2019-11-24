package com.wordpress.dixontechnologies.Mycashflow.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by ${Dixon} on 5/10/2017.
 */
public class LocationContentprovider extends ContentProvider {


    private static final String PROVIDER_CASH = "com.wordpress.dixontechnologies.Mycashflow.cash_flow_table";
    private static final String PROVIDER_EXP = "com.wordpress.dixontechnologies.Mycashflow.expenses_flow_table";
    //this link is to do operations on the coordinates table. a content provider is identified by its link.
    //public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/table_coordinates");
  //  public static final String CONTENT_URI_CASH = Uri.parse("content://" + PROVIDER_CASH + "/cash_table");
    public static final Uri CONTENT_URI_CASH = Uri.parse("content://" + PROVIDER_CASH + "/cash_table");
    public static final Uri CONTENT_URI_EXP = Uri.parse("content://" + PROVIDER_EXP + "/table_exp");
        private static final int LOCATIONS_CASH = 1;
    private static final int LOCATIONS_EXP = 2;
    private static final UriMatcher URI_MATCHER;
   // public static Uri CONTENT_URI;

    static {

        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
       // URI_MATCHER.addURI(PROVIDER_NAME, "table_coordinates", LOCATIONS);
        URI_MATCHER.addURI(PROVIDER_CASH, "cash_table", LOCATIONS_CASH);
                URI_MATCHER.addURI(PROVIDER_EXP, "table_exp", LOCATIONS_EXP);
    }

    private DBAdapter dbAdapter;
    private MyDBHelper helper;


    @Override
    public boolean onCreate() {
        helper = new MyDBHelper(getContext());
  //      dbAdapter = new DBAdapter(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, String[] strings, String s, String[] strings1, String s1) {

        if (URI_MATCHER.match(uri)==LOCATIONS_CASH){
            return dbAdapter.retrieve();
        } else if(URI_MATCHER.match(uri)==LOCATIONS_EXP){
            return dbAdapter.retrieve_Expenses();

        }

        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {


       // long rowID = dbAdapter.getCashRow_count();
//        Uri _uri = null;
//        if (rowID>0) {
//            _uri = ContentUris.withAppendedId(CONTENT_URI_CASH, rowID);
//        } else {
//            try{
//                throw new SQLException("Failed to insert :" + uri);
//            } catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
        return uri;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
