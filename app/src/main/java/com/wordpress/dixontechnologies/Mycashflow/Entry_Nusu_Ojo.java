package com.wordpress.dixontechnologies.Mycashflow;

import android.content.Context;
import android.location.Location;
import android.widget.Toast;

import java.security.PrivilegedActionException;

/**
 * Created by DIXON on 8/4/2016.
 */
public class Entry_Nusu_Ojo {

    public String getId;
    //these are the main objects that will be observed to give  predication according to user input.
    private int id;
    private int exp_id;
    private String exp_date;
    private String cash;
    private String amount;
    private String expenses;
    private String cost;
    private String time_date;



   // private Location location;


//    private double longitudes;
//    private double latitudes;


   /* private double exp_longitudes;
    private double exp_latitudes;
*/

    public Entry_Nusu_Ojo() {

    }




    public String getExp_date() {
        return exp_date;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }

    public int getExp_id() {
        return exp_id;
    }

    public void setExp_id(int exp_id) {
        this.exp_id = exp_id;
    }

    public String getTime_date() {
        return time_date;
    }

    public void setTime_date(String time_date) {
        this.time_date = time_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        setGetId(String.valueOf(id));
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


    public String getexpenses() {
        return expenses;
    }


    public void setexpenses(String expenses) {
        this.expenses = expenses;
    }


    public String getCost() {
        return cost;
    }



    public void setGetId(String id) {
        this.id = Integer.parseInt(id);
    }



    public String getid() {
        return String.valueOf(id);
    }



    public void setCost(String cost) {
        this.cost = cost;
    }


    public void getCash(String cash) {
        this.cash = cash;
    }



}


