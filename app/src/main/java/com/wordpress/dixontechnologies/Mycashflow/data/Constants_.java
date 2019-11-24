package com.wordpress.dixontechnologies.Mycashflow.data;

import android.provider.BaseColumns;

/**
 * Created by DIXON on 7/15/2016.
 */

public class Constants_ implements BaseColumns {


    //the id column for each cash Entry_Nusu_Ojo
    public static final String KEY_ID = "_id";
    //cash column names
    public static final String KEY_CASH = "cash";
    public static final String KEY_AMOUNT = "amount";
    //cash time and date row
    public static final String DATE_NAME = "record_date";
    //database table names
    public static final String TABLE_CASH = "cash_flow_table";
    public static final String TABLE_EXP = "expenses_flow_table";
    //exp rows
    public static final String EXP_KEY_ID = "exp_id";
    public static final String EXP_DATE = "exp_date";
    public static final String KEY_EXPENSES = "expenses";
    public static final String KEY_COST = "cost_";
    //coordinates needed to plot on maps.
    public static final String LONGITUDE = "longitude";
    public static final String LATITUDES = "latitudes";
    public static final String EXP_LONGITUDE = "exp_longitude";
    public static final String EXP_LATITUDES = "exp_latitudes";
    // app database name
    static final String DATABASE_NAME = "my_cash_flow_database.db";
    //that database version
    static final int DATABASE_VERSION = 3;
    //all Entry_Nusu_Ojo column names
    static final String TABLE_ALL_ENTRIES = "all_entries__table";


}
