/*
 * Copyright (c) $November 18th.2019. Property Of Muneza Dixon.
 */

package com.wordpress.dixontechnologies.Mycashflow;


import android.animation.Animator;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.StartAppSDK;
import com.wordpress.dixontechnologies.Mycashflow.data.DBAdapter;

import org.fabiomsr.moneytextview.MoneyTextView;

import java.util.Random;


/**
 * Created by ${Dixon} on 7/12/2016.
 */

public class HomeScreen extends AppCompatActivity implements TabLayout.OnTabSelectedListener, Preference.OnPreferenceChangeListener, ItemRemovedListener {

    public static final String EXTRA_REVEAL_X = "EXTRA_REVEAL_X";
    public static final String EXTRA_REVEAL_Y = "EXTRA_REVEAL_Y";
    private static final String TAG = "density_name_here";
    TabLayout tabLayout;
    FloatingActionMenu fab_call_sheets;
    DrawerLayout rootLayout;
    DBAdapter db;
    private SmoothActionDrawerToggle actionBarDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private ViewPager viewPager;
    private ImageView pull_upCash, pull_upExp;
    private TextInputEditText entry_one_exp, entry_two_exp;
    private TextInputEditText entry_one, entry_two;
    private Button save_exp;
    private Button save_cash;
    private BottomSheetBehavior cash_bottomSheetBehavior, exp_bottomSheetBehavior;
    private int state;
    private boolean doubleback = false;
    private MoneyTextView nusu_balance_tv;
    private String currency_type;
    private Preference preference;
    private SharedPreferences sharedPreferences;
    private int[] colors;
  //  private String currency;
    private View cashtab, exptab;
    private TextView cash_badge, cash_tab_title;
    private TextView exp_tabBadge, tvTwo_tabTitle;
        long backpressed;
        private View overlay;
    private InputMethodManager ipp;
    private NusuSplashView splashView;
    private DrawerLayout.LayoutParams rootLayout_paras;

    @Override
    public void onBackPressed() {
        if (backpressed + 500 > System.currentTimeMillis()) {

            super.onBackPressed();
        return;
        } else {
            Snackbar.make(getCurrentFocus(),"Press Again to close App", Snackbar.LENGTH_LONG).show();
            cash_bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            exp_bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                closeKiBoard();
            if (ipp.isActive()){
                closeKiBoard();
            }

            closeKiBoard();
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
          fab_call_sheets.close(true);
            fab_call_sheets.showMenuButton(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.share_me){
            shareAppLink();
                }
        return super.onOptionsItemSelected(item);




    }

    private void shareAppLink() {
        runOnUiThread(() -> {
            String applicationNameId = "Nusu";
            //  final String appPackageName = this.getPackageName();
            Intent i = new Intent(android.content.Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(android.content.Intent.EXTRA_SUBJECT, applicationNameId);
            String text = "\nLet me recommend you this application: ";
            String link = "https://play.google.com/store/apps/details?id=" +
                    BuildConfig.APPLICATION_ID;
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_TEXT, text + "" + link);
            startActivity(Intent.createChooser(i, "Pick Portal "));
        });
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    //==========FOLLOW THE WHITE RABBIT========//DT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootLayout_paras = new DrawerLayout.LayoutParams(
                DrawerLayout.LayoutParams.MATCH_PARENT,
                DrawerLayout.LayoutParams.MATCH_PARENT);
        splashView = new NusuSplashView(getApplicationContext());
        //setContentView(splashView, rootLayout_paras);
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) {
            setContentView(R.layout.ewwaka_as_in_home);
        //final  Intent intent = getIntent();
        } else  {
            setContentView(splashView, rootLayout_paras);
            splasView();
        }
        splasView();
        StartAppSDK.init(this,"210044288", true );
        StartAppAd.disableAutoInterstitial();
        StartAppAd.disableSplash();
        this.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        FireBaseSetUp();
        nusu_balance_tv = findViewById(R.id.nusu_avatar);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        currency_type = sharedPreferences.getString("currency_", "");
        cashtab = LayoutInflater.from(this).inflate(R.layout.nusu_badge, null);

        //badgesOnTabs();
        rabbit();
        //hideTitle();
        onClicks();
        call_sheets_views();
        settingUpPagerAndTAb();
        _navigation_View_items();
        runOnUi();
        //openV21EntryDialog();
        fab_call_sheets.setOnMenuToggleListener(opened -> {

            if (opened ){
                overlay.setVisibility(View.VISIBLE);
            }
        });
    }

    private void splasView() {
        splashView.setRemoveFromParentOnEnd(true); // remove the SplashView from MainView once animation is completed
        splashView.setSplashBackgroundColor(getResources().getColor(R.color.textColorPrimary)); // the background color of the view
        splashView.setRotationRadius(getResources().getDimensionPixelOffset(R.dimen.splash_rotation_radius)); // radius of the big circle that the little circles will rotate on
        splashView.setCircleRadius(getResources().getDimensionPixelSize(R.dimen.splash_circle_radius)); // radius of each circle
        splashView.setRotationDuration(getResources().getInteger(R.integer.splash_rotation_duration)); // time for one rotation to be completed by the small circles
        splashView.setSplashDuration(getResources().getInteger(R.integer.splash_duration)); // total time taken for the circles to merge together and disappear
        splashView.setCircleColors(getResources().getIntArray(R.array.splash_circle_colors)); // the colors of each circle in order
        startSplass();


    }

    public void startSplass(){
        Random random = new Random();

        new Handler().postDelayed(() -> revealHomeScreen(), 8000 + random.nextInt(1000));
    }

    private void revealHomeScreen() {
        rootLayout_paras = new DrawerLayout.LayoutParams(
                DrawerLayout.LayoutParams.MATCH_PARENT,
                DrawerLayout.LayoutParams.MATCH_PARENT);
        splashView.splashAndDisappear(new NusuSplashView.ISplashListener() {
            @Override
            public void onStart() {
            }
            @Override
            public void onUpdate(float completionFraction) {
                if(BuildConfig.DEBUG){
                    Log.d("TAG__SCREEN", "splash at " + String.format("%.2f", (completionFraction * 100)) + "%");
                }
            }
            @Override
            public void onEnd() {
                splashView = null;
                setContentView(R.layout.ewwaka_as_in_home);
            }
        });
    }

    private void runOnUi() {
        runOnUiThread(() -> {
            drawerAndToolbar();
            cash_bottomSheet_panel();
            expenses_bottomSheet_panel();
            adding_Cash_values_toDb();
            adding_Exp_values_toDb();
            gettingTestTotals(currency_type);

        });
    }
    private void FireBaseSetUp() {

        runOnUiThread(() -> {
            FirebaseAnalytics firebase = FirebaseAnalytics.getInstance(this);
            firebase.setAnalyticsCollectionEnabled(true);
            FirebaseOptions.Builder builder = new FirebaseOptions.Builder();
            builder.setGcmSenderId(getApplication().getResources().getString(R.string.gcm_defaultSenderId));
            FirebaseMessaging.getInstance().subscribeToTopic("nusu_updates");
            //    CheckForUpdates();
            FirebaseInstanceId.getInstance().getInstanceId()
                    .addOnCompleteListener(task -> {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "getInstanceId failed", task.getException());
                            return;
                        }
                        // Get new Instance ID token
                        String token = task.getResult().getToken();


                        Log.d(TAG, token);
                        //          Toast.makeText(getApplicationContext(), token, Toast.LENGTH_SHORT).show();
                    });
        });

    }
/*
    private void CheckForUpdates() {
        AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(this);
        com.google.android.play.core.tasks.Task<AppUpdateInfo> appUpdateInfoTask
                = appUpdateManager.getAppUpdateInfo();
        appUpdateInfoTask .addOnSuccessListener(apptaskInfo -> {
            if (apptaskInfo.updateAvailability() ==
                    UpdateAvailability.UPDATE_AVAILABLE && apptaskInfo.isUpdateTypeAllowed(
                            AppUpdateType.IMMEDIATE)){
                // Request the update.
                 appUpdateManager.startUpdateFlowForResult(
                                apptaskInfo,
                         AppUpdateType.FLEXIBLE,
                         this,
                         REQUEST_CODE);
            }
    });



        )

    }*/




    private void gettingTestTotals(String currency) {

        double cashTotal_ = Double.parseDouble(cashTotal());
        double expTotal_ = Double.parseDouble(expTotal());
        double balance = cashTotal_ - expTotal_;
        float bala_strg = Float.parseFloat(String.valueOf(balance));

        if (balance >0 ){
          nusu_balance_tv.setAmount(bala_strg, currency);
            nusu_balance_tv.setVisibility(View.VISIBLE);
        } else if (balance <0){
            nusu_balance_tv.setVisibility(View.VISIBLE);
            nusu_balance_tv.setBaseColor(getResources().getColor(R.color.red));
            nusu_balance_tv.setAmount(bala_strg, currency);
        } else{
            nusu_balance_tv.setVisibility(View.GONE);

        }

    }

    private void settingUpPagerAndTAb() {
        MyCashFlowPagerAdapter myCashFlowPagerAdapter = new MyCashFlowPagerAdapter(getSupportFragmentManager());
        tabLayout = findViewById(R.id.tablayout_);
        assert tabLayout != null;
         tabLayout.setupWithViewPager(viewPager);
         tabLayout.addTab(tabLayout.newTab().setText("Cash"));
        tabLayout.addTab(tabLayout.newTab().setText("Info"));
        tabLayout.addTab(tabLayout.newTab().setText("Expenses"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = findViewById(R.id.viewpager);
        if (viewPager != null) {
            viewPager.setAdapter(myCashFlowPagerAdapter);
        }


        assert viewPager != null;

        viewPager.setCurrentItem(tabLayout.getSelectedTabPosition(), true);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //disable swipe on viewpage. how???
        //we put tabs in xml instead of a viewpager. ...add those fragments to it.
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                        switch (i){
                            case 0:
                                fab_call_sheets.showMenuButton(true);

                                break;
                            case 1:
                                fab_call_sheets.hideMenuButton(true);
                                break;
                            case 2:
                                fab_call_sheets.isShown();
                                fab_call_sheets.showMenuButton(true);
                                break;

                        }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
//        badgesOnTabs();

    }


    private String cashTotal() {

        db = new DBAdapter(this);
        db.openDB();

        double cash_count = db.getTotalCash();

        String cashCountString = "";

        if (cash_count >= 0) {
            cashCountString = String.valueOf(cash_count);
            return cashCountString;
        }
        Log.d("COUNT WORKS", cashCountString);
        db.closeDB();
        return cashCountString;

    }

    private String expTotal() {
        db = new DBAdapter(this);
        db.openDB();
        double expTotal = db.getTotalExpenses();

        String expCountString = "";

        if (expTotal >= 0) {
            expCountString = String.valueOf(expTotal);
            return expCountString;
        }
        Log.d("COUNT WORKS", expCountString);
        db.closeDB();
        return expCountString;

    }

/*
    private void setAppBarHeight() {
        AppBarLayout appBarLayout = findViewById(R.id.appbar);
        appBarLayout.setLayoutParams(new CoordinatorLayout.
                LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                getStatusBarHeight() + dpToPx(48 + 56)));
    }

    private int getStatusBarHeight() {
        int result = 0;
        int resourceID = getResources().getIdentifier("status_bar_height",
                "dimen", "android");
        if (resourceID > 0) {
            result = getResources().getDimensionPixelSize(resourceID);
        }

        return result;
    }

    private int dpToPx(int i) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round((float) i * density);

    }

*/
    private void rabbit() {

        exp_bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.exp_bottomSheetLayout));
        pull_upCash = findViewById(R.id.dismiss);
//        pull_upExp = f
        fab_call_sheets = findViewById(R.id.fav);
        entry_one_exp = findViewById(R.id.entry_one_exp);
        entry_two_exp = findViewById(R.id.entry_two_exp);
        entry_one = findViewById(R.id.entry_one);
        entry_two = findViewById(R.id.entry_two);
        save_exp = findViewById(R.id.btn_save_dialog_exp);
        save_cash = findViewById(R.id.btn_save_dialog);
    }

    public void onClicks(){
        pull_upCash.setOnClickListener(v -> cash_bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED));
    }

    private void call_sheets_views() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cash_fab);
        FloatingActionButton floatingActionButton2 = findViewById(R.id.exp_fab);
        floatingActionButton.setOnClickListener(view -> cash_bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED));
        floatingActionButton2.setOnClickListener(view -> exp_bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED));

        //  getCashDialog();
    }

    private void cash_bottomSheet_panel() {
        cash_bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.cash_bottomSheetLayout));
        cash_bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        cash_bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    pull_upCash.setImageResource(R.mipmap.panel_up);
                }
                switch (newState) {
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        overlay.setVisibility(View.GONE);
                       fab_call_sheets.showMenuButton(true);
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        overlay.setVisibility(View.GONE);
                      break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        overlay.setVisibility(View.VISIBLE);
                        fab_call_sheets.hideMenuButton(true);
                        mDrawerLayout.closeDrawers();
                        closeDais();
                        pull_upCash.setImageResource(R.mipmap.panel_up);
                        cash_bottomSheetBehavior.isHideable();
                        exp_bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
pull_upCash.setOnClickListener(v -> cash_bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED));
                        closeKiBoard();
break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        fab_call_sheets.showMenuButton(true);

                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                 //       fab_call_sheets.hideMenuButton(false);
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

                //animating the floating action button
                //fab_call_sheets.animate().scaleX(1 - slideOffset).scaleY(1 - slideOffset).setDuration(300).start();

            }
        });


    }

    private void closeDais() {
    overlay.setOnClickListener(v -> {
        cash_bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        exp_bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        fab_call_sheets.close(true);
        mDrawerLayout.closeDrawers();
    });



    }

    private void expenses_bottomSheet_panel() {
        exp_bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        exp_bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        fab_call_sheets.showMenuButton(true);


                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:

                      //  overlay.setVisibility(View.VISIBLE);
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        mDrawerLayout.closeDrawers();
                        closeDais();
                        overlay.setVisibility(View.VISIBLE);
                        fab_call_sheets.hideMenuButton(true);
                        exp_bottomSheetBehavior.isHideable();
                        cash_bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                        View view = findViewById(R.id.dismiss_exp);
                        view.setOnClickListener(v ->  {
                             {
                                exp_bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                            }
                        });
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:

                        fab_call_sheets.showMenuButton(true);
                        overlay.setVisibility(View.GONE);

                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                /*fab_call_sheets.animate().scaleX(1 - slideOffset).
                        scaleY(1 - slideOffset).setDuration(300).start();
*/

            }
        });

    }
    //saving expenses

    private void adding_Exp_values_toDb() {


        save_exp.setOnClickListener( v -> {
             {
                try {

                    save_expenses(entry_one_exp.getText().toString().trim(),
                            entry_two_exp.getText().toString().trim(), v);
                    settingUpPagerAndTAb();
                    closeKiBoard();
                    Toast.makeText(getApplicationContext(), "Item saved"+ currency_type, Toast.LENGTH_LONG).show();
                    cash_bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

                    gettingTestTotals(currency_type);
                } catch (Exception e){
                    Log.d("error", e.toString());



                }

            }
        });


    }

    private void save_expenses(String expenses, String cost, View view) {

        db = new DBAdapter(this);
        db.openDB();

        TextInputLayout textInputLayout = findViewById(R.id.ff);
        
        if (TextUtils.isEmpty(expenses) || TextUtils.isEmpty(cost)) {
        
           textInputLayout.setError("Invalid Input ! !");
        } else if (db.insertExpenses(expenses, cost)) {
            entry_one_exp.setText("");
            entry_two_exp.setText("");

            Snackbar.make(view, "Item saved", Snackbar.LENGTH_LONG).setAction("Refresh", v ->  {
                {
                    //badgesOnTabs();
                    settingUpPagerAndTAb();
                }
            });
            db.closeDB();

        }

    }
    private void adding_Cash_values_toDb() {
        save_cash.setOnClickListener(view -> {
            try {
                saveCash(entry_one.getText().toString().trim(),
                        entry_two.getText().toString().trim(), view);
                settingUpPagerAndTAb();
                gettingTestTotals(currency_type);
                gettingTestTotals(currency_type);
               closeKiBoard();
            } catch (Exception e){
            Log.d("ip_error", e.toString());
            }
        });
    }

    private void closeKiBoard() {
       ipp = (InputMethodManager)
                getSystemService(INPUT_METHOD_SERVICE);

        ipp.hideSoftInputFromWindow(getCurrentFocus()
                .getWindowToken(), 0);
    }

    private void saveCash(String cash, String amount, View view) {

        db = new DBAdapter(this);
        db.openDB();
        TextInputLayout textInputLayout = findViewById(R.id.ff_la);

        if (TextUtils.isEmpty(cash) || TextUtils.isEmpty(amount)) {
       //     entry_one.setError("Invalid Input ! !", getResources().getDrawable(R.mipmap.yo_ex));

            textInputLayout.setErrorTextColor(ColorStateList.valueOf(getResources().getColor(R.color.red)));
            textInputLayout.setError("Invalid Input ! !");
        } else if (db.insertCash(cash, amount)) {
            entry_one.setText("");
            entry_two.setText("");
            cash_bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            Snackbar.make(view, "Item saved", Snackbar.LENGTH_LONG).setAction("Refresh", v ->  { {
                        settingUpPagerAndTAb();
                  //  badgesOnTabs();
                }
            });
            db.closeDB();

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        gettingTestTotals(currency_type);

    }

    @Override
    protected void onResume() {
        super.onResume();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        currency_type = sharedPreferences.getString("currency_", "");
        gettingTestTotals(currency_type);

    }


    private void drawerAndToolbar() {

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.whiteTextColor));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);

        }
        // getting the menu icon to work
        mDrawerLayout = findViewById(R.id.drawer_layout);
        toolbar.setNavigationIcon(R.drawable.ic_menu_48px);
        actionBarDrawerToggle = new SmoothActionDrawerToggle(this, mDrawerLayout, toolbar);
        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        toolbar.setNavigationOnClickListener(v -> mDrawerLayout.openDrawer(GravityCompat.START));
    }
    //this layout really is something if not trouble.

    //all drawer items
    private void _navigation_View_items() {
        // navigation _view to help a user navigate between the drawer items.
        NavigationView navigationView = findViewById(R.id.navigation_view);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener
                    (item -> {
                        if (item.isChecked()) item.setChecked(false);
                        else item.setChecked(true);
                        switch (item.getItemId())

                        {

                            case R.id.about_nusu:
                                actionBarDrawerToggle.runWhenIdle(() -> {
                                       Intent intent_how = new Intent(HomeScreen.this, Enkozesa.class);
                                    startActivity(intent_how);
                                    closeSeets();
                                    closeSeets();

                                });
                                mDrawerLayout.closeDrawers();
                                break;

                            case R.id.aboutUs:
                                actionBarDrawerToggle.runWhenIdle(() -> { {
                                        //opening the about screen
                                        Intent intent_about_us = new Intent(HomeScreen.this, AboutUs.class);
                                        startActivity(intent_about_us);
                                        closeSeets();

                                    }
                                });
                                mDrawerLayout.closeDrawers();
                                return true;


                            //opening the settings page
                            case R.id.settings_id:
                                                openRestDialog();
                                mDrawerLayout.closeDrawers();
                                closeDais();
                                closeSeets();

                                return true;
//
//                                case R.id.view_ad:
//                                    actionBarDrawerToggle.runWhenIdle(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            Toast.makeText(getApplicationContext(), "CurrencySlide", Toast.LENGTH_SHORT).show();
//                                            //openFragmnt();
//                                        }
//                                    });

                            case R.id.checkUpdates:

                            Toast.makeText(getApplicationContext(), "coming soon", Toast.LENGTH_SHORT).show();
                                    closeDais();
                                    closeSeets();
                                mDrawerLayout.closeDrawers();
                                break;
                        }

                        return true;

                    });
        }
    }

    private void closeSeets() {
        
                    cash_bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    exp_bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    fab_call_sheets.close(true);
    }

//    private void openFragmnt() {
//
//        Fragment currencySlide =  new CurrencySlide();
//        FragmentTransaction fragmentTransaction = currencySlide.getFragmentManager().beginTransaction();
//            fragmentTransaction.commit();
//    }

    private void openRestDialog() {
        //custom dialog look
        final ViewGroup viewGroup = findViewById(R.id.content);
        View dialogview = LayoutInflater.from(this).inflate(R.layout.activity_detail, viewGroup, false);
        Button buttonRestOk = dialogview.findViewById(R.id.buttonOk);
        Button buttonRestNo = dialogview.findViewById(R.id.buttonNo);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final Dialog dialog = new Dialog(this);
        dialog.setTitle("Rest App");
        dialog.setContentView(dialogview);
//        builder.setCancelable(true);
        dialog.show();

        buttonRestNo.setOnClickListener(v -> dialog.cancel());


        buttonRestOk.setOnClickListener(v -> {
            new Handler().postDelayed(() -> {
                Snackbar.make(getCurrentFocus(), "Reset Complete", Snackbar.LENGTH_LONG).show();
                dialog.dismiss();
            }, 1500);
            resetFun(viewGroup, dialog);
            Snackbar.make(getCurrentFocus(), "Please wait...", Snackbar.LENGTH_SHORT).show();


        });

    }

    void hideTitle(){
        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapseToolbar);
        AppBarLayout appBarLayout = findViewById(R.id.appbar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShown = true;
            int scrollRange =-1;
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (scrollRange == -1){
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + i == 0){
                    collapsingToolbarLayout.setTitle(getResources().getString(R.string.app_name));
                } else if (isShown) {
                    collapsingToolbarLayout.setTitle(" ");
                    isShown = false;
                }
            }
        });
    }



    private void resetFun(final View v, final Dialog dialog) {
        db  = new DBAdapter(this);
        db.openDB();
        try {

            if ( db.getCashRow_count() >=0 ||  db.getExpRow_count() >=0 ){
                        db.clear();
                        Toast.makeText(getApplicationContext(), "Deleting items...Please Wait", Toast.LENGTH_LONG).show();
                    rabbit();
                    settingUpPagerAndTAb();
                    onContentChanged();
                    gettingTestTotals(currency_type);
            } else {
                Toast.makeText(getApplicationContext(), "You have not added any item",Toast.LENGTH_SHORT).show();
            }

            db.closeDB();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {


    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object o) {

        return true;
    }

    @Override
    public void onItemRemovedListener(int pos) {

        Toast.makeText(this, "deleted" + pos, Toast.LENGTH_SHORT).show();
    }


public void openV21EntryDialog(){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        View viewGroup = LayoutInflater.from(getApplicationContext()).inflate(R.layout.mycash, (ViewGroup) getCurrentFocus());
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        builder.setView(viewGroup);
      TextInputEditText entry_one =    viewGroup.findViewById(R.id.entry_one);
      TextInputEditText  entry_two = viewGroup.findViewById(R.id.entry_two);
      Button save_exp = viewGroup.findViewById(R.id.btn_save_dialog_exp);
      Button   save_cash = viewGroup.findViewById(R.id.btn_save_dialog);
                openV21SaveDialog(entry_one, entry_two, save_cash);


    }
}

    private void openV21SaveDialog(final TextInputEditText entry_one, final TextInputEditText entry_two, Button save_cash) {
        save_cash.setOnClickListener(view -> {
            try {

                save_cash_(entry_one.getText().toString().trim(),
                        entry_two.getText().toString().trim(), view);
                settingUpPagerAndTAb();
                Toast.makeText(getApplicationContext(), "tttt"+ currency_type, Toast.LENGTH_LONG).show();
            } finally {
                //refreshTabs();
                //  badgesOnTabs();
                gettingTestTotals(currency_type);

            }

        });

        }

    private void save_cash_(String trim, String trim1, View view) {
        db = new DBAdapter(this);
        db.openDB();

        if (TextUtils.isEmpty(trim) || TextUtils.isEmpty(trim1)) {
            entry_one.setError("Invalid Input ! !", getResources().getDrawable(R.mipmap.yo_ex));

        } else if (db.insertCash(trim, trim1)) {
            entry_one.setText("");
            entry_two.setText("");
            cash_bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            Snackbar.make(view, "Item saved", Snackbar.LENGTH_LONG).setAction("Refresh", view1 -> {
                settingUpPagerAndTAb();
            });

            db.closeDB();

        }    }

}