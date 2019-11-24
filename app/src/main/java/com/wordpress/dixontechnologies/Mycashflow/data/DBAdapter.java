package com.wordpress.dixontechnologies.Mycashflow.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.wordpress.dixontechnologies.Mycashflow.Entry_Nusu_Ojo;

import java.util.ArrayList;

/**
 * Created by DIXON on 8/14/2016.
 */
public class DBAdapter {


   public SQLiteDatabase database;
   private MyDBHelper helper;
    private String[] all_columns;


    public DBAdapter(Context c) {
        helper = MyDBHelper.getInstance(c);
        all_columns = new String[]{
                Constants_.KEY_ID,
                Constants_.KEY_CASH,
                Constants_.KEY_AMOUNT,
                Constants_.DATE_NAME,
                Constants_.EXP_KEY_ID,
                Constants_.KEY_EXPENSES,
                Constants_.KEY_COST};

 }

    //open db
    public void openDB(){
        try {

            database = helper.getWritableDatabase();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //close db
    public void closeDB(){
        try {
            helper.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public double getlast24hrs_data() {
        // SELECT * FROM  myTable  WHERE timeStamp>DATETIME('NOW','-1 DAY')
        //all the code goes here.

        double yesterdays_data;
        double no_data =00.00000;
        Cursor cursor = database.rawQuery("SELECT * FROM " +
                " cash_flow_table WHERE record_date >= DATETIME('NOW', '-1 DAY')", null);

        /*+ " AND DATETIME('NOW', localtime)"*/
        try {
            if (cursor.moveToFirst())

                yesterdays_data = cursor.getDouble(0);
            else
                yesterdays_data = -1;

            cursor.close();

            return yesterdays_data;

        }catch (Exception e){
            e.printStackTrace();
        }
        return no_data;
    }


    //inserting cash entries
    public boolean insertCash(String cash, String amount) {
        try {
            ContentValues cv_cash_entries = new ContentValues();
            cv_cash_entries.put(Constants_.KEY_CASH, cash);
            cv_cash_entries.put(Constants_.KEY_AMOUNT, amount);
            cv_cash_entries.put(Constants_.DATE_NAME, java.lang.System.currentTimeMillis());
            database.insert(Constants_.TABLE_CASH,Constants_.KEY_ID, cv_cash_entries);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public long insertCash_LatLng(ContentValues contentValues) {
        return database.insert(Constants_.TABLE_CASH, null, contentValues);
    }


    public int del(){
        return database.delete(Constants_.TABLE_CASH, null, null);


    }


    public Cursor getAllLOcations(){
        return  database.query(Constants_.TABLE_CASH, new String[]{
                Constants_.KEY_ID, Constants_.KEY_CASH, Constants_.KEY_AMOUNT, Constants_.DATE_NAME}, null,
                null, null,null,null);
    }



    public boolean insertExpenses(String expense, String cost) {
        try {
            ContentValues cv_expenses = new ContentValues();
            cv_expenses.put(Constants_.KEY_EXPENSES, expense);
            cv_expenses.put(Constants_.KEY_COST, cost);
            cv_expenses.put(Constants_.EXP_DATE, java.lang.System.currentTimeMillis());
            database.insert(Constants_.TABLE_EXP, Constants_.EXP_KEY_ID, cv_expenses);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }   //inserting expected cash into db

    // insert/save
    public Cursor retrieve() {
        String[] columns = {Constants_.KEY_ID,
                Constants_.KEY_CASH,
                Constants_.KEY_AMOUNT,
                Constants_.DATE_NAME};

        return  database.query(Constants_.TABLE_CASH, columns, null, null, null, null, null);
    }
    //getting exp items with bearings

    public Cursor retrieve_Expenses() {
        String[] columns = {Constants_.EXP_KEY_ID,
                Constants_.KEY_EXPENSES,
                Constants_.KEY_COST,
                 Constants_.EXP_DATE};

        return  database.query(Constants_.TABLE_EXP, columns, null, null, null, null, null);
    }

    //Delete rows
    public boolean delete(int id) {
        return database.delete(Constants_.TABLE_CASH,
                Constants_.KEY_ID + "=" + id, null ) > 0;
    }

    public boolean delete_exp( int id2) {
        return database.delete(Constants_.TABLE_EXP,
                Constants_.EXP_KEY_ID + "=" + id2, null ) > 0;
    }


    public Cursor getchartdata(){

        String[] columns = {Constants_.KEY_ID,
                Constants_.KEY_CASH,
                Constants_.KEY_AMOUNT,
                Constants_.DATE_NAME};

//        database = helper.getReadableDatabase();


        String query ="SELECT _id, cash," +
                " amount FROM cashflow_table WHERE record_date <= datetime('now','weekday','-1 day')";

       try {

           return database.rawQuery(query, null);
       }catch (Exception r){
           r.printStackTrace();
       }
        return database.query(Constants_.TABLE_CASH,columns, null, null,null,null,null);
    }


    public Cursor getExpchartdata(){

        String[] columns = {Constants_.EXP_KEY_ID,
                Constants_.KEY_EXPENSES,
                Constants_.KEY_COST,
                Constants_.EXP_DATE};

//        database = helper.getReadableDatabase();
        String query = "select exp_id, cash," + "exp_date," + "cost_" + " FROM expenses_flow_table";
  //      database.close();
       try {
           return database.rawQuery(query, null);
       }catch (Exception r){
           r.printStackTrace();
       }
        return database.query(Constants_.TABLE_EXP,columns, null, null,null,null,null);

    }

        //use this to get weekly cash values.
public Cursor getWeek_Actitvity(){

        String query = ("SELECT _id, amount, record_date FROM cash_flow_table WHERE record_date > DATETIME('now','-1 day')");

    return database.rawQuery(query,null);

}



    public double getTotalExpenses() {
        double sum;

       /* Cursor exp =
                database.rawQuery

                        ("SELECT SUM (cost_) AS TOTAL FROM " +
             Constants_.TABLE_EXP + " WHERE " + Constants_.EXP_DATE + " > DATE('now', '-1 day')", null);
*/
//real expenses code.
          Cursor exp =
                database.rawQuery
                        ("SELECT SUM (cost_) AS TOTAL FROM " +
                                Constants_.TABLE_EXP, null);


        if (exp.moveToFirst())
            sum = exp.getDouble(0);
        else
            sum = -1;
        exp.close();



        return sum;
    }


    public double getTotalCash() {
        // openDB();
        double sum;

    //    SELECT * FROM  myTable  WHERE timeStamp>DATETIME('NOW','-1 DAY')

    /* yesterday's data
     Cursor inc = database.rawQuery("SELECT SUM (amount) AS TOTAL FROM " +
                "cash_flow_table WHERE record_date > DATETIME('NOW','-1 DAY') " +
                        "AND DATETIME('NOW' , 'localtime')",   null);

*/    Cursor inc =
                database.rawQuery
                        ("SELECT SUM (amount) AS TOTAL FROM " +
                                Constants_.TABLE_CASH, null);


        try{
    if(inc.moveToFirst())
        sum = inc.getDouble(0);
    else
        sum = -1;

    inc.close();
    return sum;
} catch (Exception e_1){
    e_1.printStackTrace();
   Log.d("cash amount", String.valueOf(e_1));

}
if(inc.moveToFirst())
            sum = inc.getDouble(0);
        else
            sum = -1;

        inc.close();
        return sum;
    }




    public double getMaxCash() {
        // openDB();
        double sum;
        Cursor inc =
                database.rawQuery
                        ("SELECT MAX (amount) FROM " + Constants_.TABLE_CASH, null);
        if(inc.moveToFirst())
            sum = inc.getDouble(0);
        else
            sum = -1;
        inc.close();
        return sum;
    }

    public int getCashRow_count(){

      database= helper.getReadableDatabase();
        int munezA = 0;
        Cursor cursor1 = database.rawQuery("SELECT COUNT (*) FROM cash_flow_table " , null);
        if ( cursor1.moveToFirst()) {
            munezA = cursor1.getInt(0);
        }

        cursor1.close();
        return munezA;
    }


    //how many exp items
public int getExpRow_count() {

    int dixon = 0;
    database = helper.getReadableDatabase();
    Cursor cursor = database.rawQuery("SELECT COUNT (*)  FROM expenses_flow_table ", null );
    if (cursor.moveToFirst()){
        dixon = cursor.getInt(0);
    }
    cursor.close();
    return dixon;
}


    public void clear(){
                String clear = "DELETE FROM " + Constants_.TABLE_EXP;
    String clear_cash = "DELETE FROM " + Constants_.TABLE_CASH;
    database.execSQL(clear);
    database.execSQL(clear_cash);
    //database.


}

    public boolean UPDATE_CASH_TABLE( int id, String cash, String amount) {
        ContentValues values  = new ContentValues();
        values.put(Constants_.KEY_CASH, cash);
        values.put(Constants_.KEY_AMOUNT, amount);
        return database.update(Constants_.TABLE_CASH,
                values, Constants_.KEY_ID
                        + "=" + id, null) > 0;
}

    public boolean UPDATE_EXP_TABLE( int id, String exp, String cost) {

            ContentValues values  = new ContentValues();
            values.put(Constants_.KEY_EXPENSES, "exp");
            values.put(Constants_.KEY_COST, "cost");
            return database.update(Constants_.TABLE_EXP,
                    values, Constants_.KEY_COST + "=" + id, null) > 0;

    }



    public ArrayList<Integer> getIncremental_CASH_Data(){

        ArrayList<Integer> cash_values = new ArrayList<Integer>();
        String[] cash_columns = new String[]{Constants_.KEY_ID,Constants_.KEY_CASH, Constants_.KEY_AMOUNT, Constants_.DATE_NAME};
        Cursor c = database.query(Constants_.TABLE_CASH, cash_columns, null, null, null, null, null);
        int result = 0;
        int icash = c.getColumnIndex(Constants_.KEY_ID);
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            result = Integer.parseInt(c.getString(icash));
            cash_values.add(result);
        }
        c.close();

        return cash_values;
    }
    public ArrayList<String> getCash_Arraylist(){

        ArrayList<String> cash_values = new ArrayList<String>();
        String[] cash_columns = new String[]{Constants_.KEY_ID,Constants_.KEY_CASH, Constants_.KEY_AMOUNT, Constants_.DATE_NAME};
        Cursor c = database.query(Constants_.TABLE_CASH, cash_columns, null, null, null, null, null);

        String result_;
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){

            result_ = c.getString(Integer.parseInt(Constants_.KEY_CASH));
            cash_values.add(result_);
        }
        c.close();

        return cash_values;
    }


    public int lastmonthcashcount() {
        database= helper.getReadableDatabase();
        int munezA = 0;
        Cursor cursor1= database.rawQuery("SELECT SUM (amount) AS TOTAL FROM " +
                "cash_flow_table WHERE record_date == datetime('now','weekday','-1 day') " +
                "AND datetime('now' , 'localtime')",   null);

        if ( cursor1.moveToFirst()) {
            munezA = cursor1.getInt(0);
        }


        cursor1.close();
        return munezA;
    }

    public Cursor getallExp_locations() {
        return  database.query(Constants_.TABLE_EXP, new String[]{
                Constants_.EXP_KEY_ID, Constants_.KEY_EXPENSES,
                Constants_.KEY_COST, Constants_.EXP_DATE,
                Constants_.EXP_LATITUDES,Constants_.EXP_LONGITUDE},null,
                null, null, null, null);


    }

    public long insertNew_exp(ContentValues contentValues) {
        return database.insert(Constants_.TABLE_EXP, null, contentValues);
    }


    //the code to update row.
    public void updateCashTable(Entry_Nusu_Ojo nusu_ojo){

        ContentValues cv =  new ContentValues();
        cv.put("id", nusu_ojo.getId());
        cv.put("item", nusu_ojo.getCash());
        cv.put("amount", nusu_ojo.getAmount());
        cv.put("time_stamp", nusu_ojo.getTime_date());
        database.update(Constants_.TABLE_CASH, cv, Constants_.KEY_ID + "=?" + nusu_ojo.getId, null);
    }




    public int delExP() {
        return database.delete(Constants_.TABLE_EXP, null, null);
    }
}



