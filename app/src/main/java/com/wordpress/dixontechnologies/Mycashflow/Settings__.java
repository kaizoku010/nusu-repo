//package com.wordpress.dixontechnologies.Mycashflow;
//
//import android.content.SharedPreferences;
//import android.os.Build;
//import android.preference.PreferenceManager;
//import android.support.annotation.RequiresApi;
//import android.support.design.widget.Snackbar;
//import android.support.design.widget.TextInputEditText;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.Button;
//import android.widget.Spinner;
//import android.widget.TextView;
//
//import com.wordpress.dixontechnologies.Mycashflow.data.DBAdapter;
//
//import java.util.Objects;
//
//public class Settings__ extends AppCompatActivity {
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.settings_view);
//       /* String sysmbol = getResources().getResourceName(R.array.currency_entries);
//        String desc = getResources().getResourceName(R.array.currency_values);
//*/
//        Button button = findViewById(R.id.reset_app_btn);
//
//
///*
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DBAdapter dbAdapter = new DBAdapter(getApplicationContext());
//                dbAdapter.openDB();
//                dbAdapter.clear();
//                dbAdapter.closeDB();
//
//                checkIfDataExists(dbAdapter);
//            }
//        });
//*/
//
//
//
//    }
//
//
//
//    private void checkIfDataExists(DBAdapter dbAdapter) {
//        if (dbAdapter.getCashRow_count() >= 0) {
//            Snackbar.make(getCurrentFocus(), "Failed", Snackbar.LENGTH_LONG).show();
//        }else{
//            Snackbar.make(getCurrentFocus(), "Finished", Snackbar.LENGTH_LONG).show();
//        }
//
//    }
//}
//
//
