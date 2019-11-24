package com.wordpress.dixontechnologies.Mycashflow;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class SettingsFrag extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    /*ActionBarActivity*/


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Toolbar bar;
            ViewGroup root =  findViewById(android.R.id.content);
            LinearLayout content = (LinearLayout) root.getChildAt(0);
            root.removeAllViews();
            bar = (Toolbar) LayoutInflater.from(this).inflate(R.layout.dropdead, root, false);
            int height;
            TypedValue tv = new TypedValue();
            if (getTheme().resolveAttribute(R.attr.actionBarSize, tv, true)){
                height = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());

            } else {
                height = bar.getHeight();
            }

            bar.setNavigationIcon(R.drawable.md_nav_back);

            content.setPadding(0, height, 0, 0);
            root.addView(content);
            root.addView(bar);

            bar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });

        }





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new MainPrefFrag())
                    .commit();
        }



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

        }







    public static class MainPrefFrag extends PreferenceFragmentCompat
            implements SharedPreferences.OnSharedPreferenceChangeListener {

        SharedPreferences sharedPreferences;

        @Override
        public void onCreatePreferences(Bundle bundle, String s) {
            setPreferencesFromResource(R.xml.preferences, s);
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
//            onSharedPreferenceChanged(sharedPreferences, getString(R.string.currency_type));



        /*ListPreference nusuCurrency = (ListPreference) this.getPreferenceManager().findPreference("mulla_key") ;
            nusuCurrency.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object o) {

                    if (preference instanceof ListPreference){
                        preference.setSummary(nusuCurrency.getValue());
                        int index = nusuCurrency.findIndexOfValue("");
                        nusuCurrency.setEntries(index);
                    }

                    return true;
                }
            });
*/

        }


        @Override
        public void onDisplayPreferenceDialog(android.support.v7.preference.Preference preference) {
            // Try if the preference is one of our custom Preferences
            DialogFragment dialogFragment = null;

/*
            if (preference instanceof ResetDialog) {
                dialogFragment = AI.newInstance(preference.getKey());
                dialogFragment.setTargetFragment(this, 0);
                assert getFragmentManager() != null;
                dialogFragment.show(getFragmentManager(),
                        "android.support.v7.preference.PreferenceFragment.DIALOG");
                Log.i("hello....", "It Works");
                this.getFragmentManager().executePendingTransactions();

            }*/
            // If it was one of our cutom Preferences, show its dialog


            if (dialogFragment != null && dialogFragment.isVisible()){

                if (preference instanceof ResetDialog) {
                    dialogFragment = AI.newInstance(preference.getKey());
                    dialogFragment.setTargetFragment(this, 0);
                    assert getFragmentManager() != null;
                    dialogFragment.show(getFragmentManager(),
                            "android.support.v7.preference.PreferenceFragment.DIALOG");
                    Log.i("hello....", "It Works");
                    this.getFragmentManager().executePendingTransactions();

                }
            }




            if (dialogFragment != null) {
                dialogFragment.setTargetFragment(this, 0);
                dialogFragment.show(this.getFragmentManager(),
                        "android.support.v7.preference" +
                                ".PreferenceFragment.DIALOG");
                Log.e("hello3....", "It Works");

            }
            // Could not be handled here. Try with the super method.


            else {
                super.onDisplayPreferenceDialog(preference);
            }
        }

        @Override
        public boolean onPreferenceTreeClick(android.support.v7.preference.Preference
                                                             preference) {

           if (preference instanceof android.support.v7.preference.ListPreference){
               android.support.v7.preference.ListPreference listPreference =
                       (android.support.v7.preference.ListPreference) preference;
               preference.setSummary(listPreference.getEntry());
               int index = listPreference.findIndexOfValue("");
               listPreference.setEntries(index);

              }
            return super.onPreferenceTreeClick(preference);
        }

        @Override
        public void onResume() {
            super.onResume();
                getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);

        }

        @Override
        public void onPause() {
            super.onPause();
            getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        }

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

               /* if (key.equals("mulla_type")) {
                   ListPreference listPreference = (ListPreference) sharedPreferences;
                   android.support.v7.preference.Preference
                            preference = findPreference(key);
                    preference.setSummary(sharedPreferences.getString(key, ""));
                    int index = listPreference.findIndexOfValue("");
                    listPreference.setEntries(index);
                }*/
        }
    }
}