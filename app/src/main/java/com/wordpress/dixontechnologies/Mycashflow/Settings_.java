//package com.wordpress.dixontechnologies.Mycashflow;
//
//
//import android.os.Build;
//import android.os.Bundle;
//import android.support.annotation.RequiresApi;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.ImageView;
//
///**
// * Created by DIXON on 10/12/2016.
// */
//
//
//
//public class Settings_ extends AppCompatActivity {
//
//    private ImageView back_;
//    ImageView back_home_settings;
//    View view;
//
//    @RequiresApi(api = Build.VERSION_CODES.M)
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.settings);
///*
//
//        android.app.ActionBar actionBar =  getActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }
//        getFragmentManager().beginTransaction()
//                .replace(android.R.id.content,
//                        new SettingsFrag()).commit();
//
//*/
//
//
//
//
//
//
//    }
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//    }
//
//    //
////  @Override
////    public void onBuildHeaders(List<PreferenceActivity.Header> target){
////      //  loadHeadersFromResource(R.xml.settings_headers, target);
////  }
//
//
//}
//
//
////    private void createBackUp() throws IOException {
////        try {
////            src = new File(fromCurentDataPath);
////            dst = new File(data_file);
////            FileInputStream in = new FileInputStream(src);
////            FileOutputStream out = new FileOutputStream(dst);
////            byte[] buffer = new byte[1024];
////            int length;
////            while ((length = in.read(buffer)) > 0) {
////                out.write(buffer, 0, length);
////            }
////
////            out.flush();
////            out.close();
////            in.close();
////            Toast.makeText(getApplicationContext(), "data backup created", Toast.LENGTH_SHORT).show();
////
////
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////
////          /*  final String currentDatapath = "/data/data/com.wordpress.dixontechnologies.cashflow/databases/cash_flow_database";
////            File data_file = new File(currentDatapath);
////            FileInputStream fis =  new FileInputStream(data_file);
////
////            String outFolderName = Environment.getExternalStorageDirectory() + "/database_copy.db";
////
////            OutputStream outputStream = new FileOutputStream(outFolderName);*/
////
////
////
////
////
////    }
//
//
//
//
////    private void resettingTheApp() {
////        ImageButton reset_b = (ImageButton) findViewById(R.id.reset_);
////         //back_ = (ImageView) findViewById(R.id.back_);
////
////        //assert back_ != null;
////       /* back_.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick( View v ) {
////                onBackPressed();
////            }
////        });*/
////
////        if (reset_b != null) {
////            reset_b.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick( View v ) {
////                    hmm();
////
////
////                }
////            });
////        }
////
////
////    }
//
////    private void hmm() {
////        //this code call onto the app database to rest the app...putting all fields back to zero
////        //after clicking the proceed option
////        DialogFragment newFragment = new ResetDialog();
////        newFragment.show(getSupportFragmentManager(), "reset");
////
////
////    }
