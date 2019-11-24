package com.wordpress.dixontechnologies.Mycashflow;

import android.os.Bundle;
import android.preference.Preference;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.preference.DialogPreference;
import android.support.v7.preference.PreferenceDialogFragmentCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.security.SecureRandom;

/**
 * Created by DIXON on 7/24/2016.
 */
public class AI extends PreferenceDialogFragmentCompat  {


    public static AI newInstance(String key) {
        final  AI fragment = new AI();
        final Bundle b = new Bundle(1);
        b.putString(ARG_KEY, key);
        fragment.setArguments(b);
        return fragment;
  }


    @Override
    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("WORRKSS");
        builder.show();
/*

        DialogPreference dialogPreference = getPreference();
        if(dialogPreference instanceof ResetDialog) {
            ResetDialog resetDialog = ((ResetDialog) dialogPreference);
            resetDialog.isShown();
            Toast.makeText(getContext(), "IT WORKSSS", Toast.LENGTH_SHORT).show();
        }

        ImageView yes_ = view.findViewById(R.id.tick_delete);
        ImageView no_ = view.findViewById(R.id.x_cancel);
        yes_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "works", Toast.LENGTH_SHORT).show();
            }
        });

*/

        }





    /* this class is the main app algorithm that will predict how much different users will be saving
                                  or
                                   spending in the near future.
                                    ....this is my design.....


           if (the user keeps recording his cashflow for more than 14 days in a row){
         save data to cashflow_database server for further scrutiny.

             <----observe the data recorded, display how much each item changes after 14days for app_users till 30 days(FREE TRIAL) (GO PRO) u can register
              with the (full version)----thoughts>,

                      display the largest item spent on and each figure.
                      }else {
           display the largest sum of amount recorded in the last five 14 days including their Entry_Nusu_Ojo database to
           predict how much a user is likely to Earn in the next 2weeks based
                                                            on their past cash flow pattern.....
       }

           The main purpose of this App is to estimate(PREDICT IS THE RIGHT WORD) how much a user will be spending or earning. ie
            (in 2weeks, 1month, 2months, 4months, 8months) this will depend on the data recorded.
             // yeah and i have no idea how to fix that, honestly.
            i am supposed to figure that out for this to make any money off it. oct.10/30/2016 <---i figured it--->
             its like creating an AI
                           THAT HAS TO LOOK INTO THE FUTURE OF ONE'S SPENDING.
              LISA....this AI, will monitor the user input for at least a period of 1month.
             Draw graphs depending on the user input after 3weeks.
              predict graphs after 1month
              _____________________________________________________________________________________________________________
              new day.
         11:48AM monday/8/2016
         i recently fell across an article online about the GooglePredictiveAPI.
          this api finds patterns in user data uploaded on the cloud and predicts outcomes.
         which is wat i want LISA to do.

         LISA 0.1 first try....
          .....collecting variables
          variables in this classLISA() will be private.
          read quick intro on classLISA() ; above


          int day_of_the_week;
          int monday, tuesday, wednesday;
          int thursday, friday, sato , sunday;
          int future_expenses;
          int future_cash;

      //    LISA();
      /*if (user has used the app > 14days, which is two weeks...and has all the data for 14days)
          * display all cash_entries on monday, tuesday, wednesday, thursday, friday, sato and sunday...(BY DATE) in the previous 14ays
          * display all expenses_entries on monday, tuesday, thursday, friday, sato and sunday...(BY DATE) in the previous 14days
          *  add total of Entry_Nusu_Ojo per day starting from a(day's_totals);
          *     ie. mondays = 28000
          *           tuesdays = 29000
          * if (you are at the end of the list, stop, otherwise, go on to the next day).
          *    getWeeklySum();
          *       add all entries for a week(14days) *  2 or any future int....//which will be 28days in this situation.
          *
          *       MULTIPLYING THIS DATA BY TWO MEANS MULTIPLYING IT BY TWO WEEKS
          *       if the user cash sum is incremented or decremented , display the predicted value;
          *       if the user expenses is incremented or decremented, display possible out come;
          *     getPrediction();
          *               Subtract  future_cash    -   future_expenses;
          *               display future_totals.
          *     futureWeeklyTotals();
          *               while(futureTotals = !null) {
          *
          *              IT WILL CHANGE GRADUALLY ACCORDING TO ENTRY CHANGES.
                    }
              futureDailyTotals();
              * getInt_past_day_entries();
               * add entries of particular for 14days.
               *
               *   extract totals for each day,
               *          ie
                *             wednesdayTotals_In14days = 50000 x 14days;
                *             tuesdayTotals_In14days = 4000 x 14days;
                *             mondayTotals_In14days = 3000 x 14days;
          futureDailyTotals();


      */


    @Override
    public void onDialogClosed(boolean b) {
        DialogFragment dialogFragment = null;
        if (b){
            DialogPreference dialogPreference = null;
            if (dialogPreference instanceof  ResetDialog){
                Toast.makeText(getContext(), "SHOW DIALOG HERE?", Toast.LENGTH_SHORT).show();
            }
        }

    }

    //Lisa is the method that monitors the cashflow_database, compute sums and predict values.
    // including previous day entries computations
    private void liSA() {
        getInt_past_day_entries();
        getWeeklySum();
        futureDailyTotals();
        futureWeeklyTotals();
        getPrediction();
    }


    private static void getInt_past_day_entries(){

        SecureRandom secureRandom = new SecureRandom();
        byte aByte[] = new byte[20];
        secureRandom.nextBytes(aByte);
    }
    //she will also get weekly sums from our database
    private static void  getWeeklySum(){

    }
    //she will predict future totals too
    private static void futureDailyTotals(){

    }
    //prediction // STOPSHIP: 8/8/2016
    private static void  futureWeeklyTotals(){
    }
    //the fun part.
    private void getPrediction(){



    }
 /* private void currency_change() {
        View currency_layout = View.inflate(getApplicationContext(), R.layout.select_currency, swipeRefreshLayout);
        //the shillings check box
            CheckBox shillings = (CheckBox) currency_layout.findViewById(R.id.shillings);
            shillings.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged( CompoundButton buttonView, boolean isChecked ) {
                if (buttonView.isChecked()){
                    pullingData();
                }else {
                    dollar_checkbox();
                }


            }
        });


        //the dollars check box
        CheckBox dollars = (CheckBox) currency_layout.findViewById(R.id.dollars);
        dollars.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged( CompoundButton buttonView, boolean isChecked ) {
                if (buttonView.isChecked()) {
                    dollar_checkbox();

                } else {
                    pullingData();

                }

            }
        });


    }

    private void dollar_checkbox() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###,###.");
        decimalFormat.setDecimalSeparatorAlwaysShown(true);
        decimalFormat.getCurrency();
        DBAdapter db = new DBAdapter(this);
        db.openDB();
        String raw_data  = String.valueOf((db.getTotalCash() - db.getTotalExpenses()));
           //formating the shillings to dollars, i hope it works.
            String dollars = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(raw_data);
            textView_grandTotal.setText(dollars);
            textView_grandTotal.setVisibility(View.VISIBLE);
        }*/



}




