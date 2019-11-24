package com.wordpress.dixontechnologies.Mycashflow;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.wordpress.dixontechnologies.Mycashflow.data.DBAdapter;

import java.util.jar.Attributes;

/**
 * Created by DIXON on 10/12/2016.
 */
public class ResetDialog extends android.support.v7.preference.DialogPreference {
    private View v;
    DBAdapter db;
    int mRestdialogPref = R.layout.activity_detail;




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ResetDialog(Context context){
        this(context, null);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ResetDialog(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0);
        setDialogLayoutResource(mRestdialogPref);
        setPositiveButtonText("Ok");
        setNegativeButtonText("Nassing");
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ResetDialog(Context context, AttributeSet attributeset, int defstyleAttr) {
        this(context, attributeset,defstyleAttr, defstyleAttr);

    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ResetDialog(Context context, AttributeSet attributes, int defstyleAttr, int defResAttrs) {
        super(context, attributes, defstyleAttr, defResAttrs);

    }


    @Override
    public int getDialogLayoutResource() {
        return mRestdialogPref;
    }


    private void deleteFunc() {

        db   = new DBAdapter(getContext());
        db.openDB();
        try {

            if ( db.getCashRow_count() > 0 ||  db.getExpRow_count() > 0 ){

                ProgressBar progressBar = new ProgressBar(getContext());
                progressBar.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        db.clear();
                        Snackbar.make(v.findFocus(), "Deleting items...Please Wait", Snackbar.LENGTH_LONG).show();
                    }
                }, 5000);
                Snackbar.make(v.findFocus(), "Reset Complete..", Snackbar.LENGTH_SHORT).show();

            } else if( db.getCashRow_count()  < 0 ||  db.getExpRow_count() < 0 ){
                Snackbar.make(v.findFocus(), "You have not added any item", Snackbar.LENGTH_LONG).show();

            }

            db.closeDB();
        } catch (Exception e){
            e.printStackTrace();
        }

    }




}