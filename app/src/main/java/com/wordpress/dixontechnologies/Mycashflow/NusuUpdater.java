//package com.wordpress.dixontechnologies.Mycashflow;
//
//import android.app.ActionBar;
//import android.app.AlertDialog;
//import android.content.ComponentName;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.database.Cursor;
//import android.os.AsyncTask;
//import android.os.Build;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.util.Log;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//
//import com.madx.updatechecker.lib.UpdateRunnable;
//import com.wordpress.dixontechnologies.Mycashflow.data.Constants_;
//import com.wordpress.dixontechnologies.Mycashflow.data.DBAdapter;
//
//import org.jsoup.Jsoup;
//
//import java.io.IOException;
//import java.security.SecureRandom;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.concurrent.ExecutionException;
//
//import im.delight.apprater.AppRater;
//
//public class NusuUpdater extends AppCompatActivity {
//    private ImageView back_help;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        String package_name =  "com.wordpress.dixontechnologies.Mycashflow";
//
//        AppRater appRater = new AppRater(this, package_name);
//        appRater.setLaunchesBeforePrompt(4);
//        appRater.setTargetUri("dixon your app link goes here");
//        appRater.setPhrases("Rate This App",
//                "You like this app?\nWe would be very happy if you could rate our application on Google Play.\nThanks for your Support!",
//                "Rate now","Later","No, thanks");
//
//        appRater.show();
//
//
//    }
//
//
//    private class NusuVersionChecker extends AsyncTask<Void, String, String> {
//
//        String newCode;
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//
//            if (s != null && !s.isEmpty()){
//                if (Float.valueOf(newCode) < Float.valueOf(s)) {
//                    openDai();
//
//                } else if (Float.valueOf(newCode) > Float.valueOf(s)){
//                    Toast.makeText(getApplicationContext(), "App Already Updated", Toast.LENGTH_LONG).show();
//                }
//            }
//
//        }
//
//        @Override
//        protected String doInBackground(Void... voids) {
//
//            try {
//                newCode = Jsoup.connect(
//                        "https//play.google.com/store/apps/details?id =" +
//                                "package name" + "&hl=en")
//                        .timeout(3000)
//                        .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
//                        .referrer("http://bing.com")
//                        .get()
//                        .select(".hAyfc .htlgb")
//                        .get(7)
//                        .ownText();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return newCode;
//
//
//
//        }
//    }
//
//    private void openDai() {
//        AlertDialog.Builder updater = new AlertDialog.Builder(getApplicationContext());
//        updater.setMessage("Update Available");
//        updater.setTitle("Nusu Updates");
//        updater.setPositiveButton("Update Nusu?", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                int applicationNameId = getApplicationContext().getApplicationInfo().labelRes;
//                final String appPackageName = getApplicationContext().getPackageName();
//                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
//                String link = "https://play.google.com/store/apps/details?id=" + appPackageName;
//                intent.setType("text/plain");
//                intent.putExtra(Intent.EXTRA_TEXT, link);
//                startActivity(Intent.createChooser(intent, "Update Nusu"));
//            }
//        });
//
//        updater.show();
//
//    }
//}