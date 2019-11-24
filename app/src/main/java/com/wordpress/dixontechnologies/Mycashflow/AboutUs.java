package com.wordpress.dixontechnologies.Mycashflow;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.app.ActionBar;
import android.widget.ImageView;
import android.widget.TextView;



import java.security.SecureRandom;

public class AboutUs extends AppCompatActivity {
    private ViewPager pager;

    private ImageView back_home;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        About_pagerAdapter about_pagerAdapter = new About_pagerAdapter(getSupportFragmentManager());
       tabLayout = findViewById(R.id.tab_layout);
        assert tabLayout != null;
        tabLayout.setupWithViewPager(pager);
        tabLayout.addTab(tabLayout.newTab().setText("About"));
        tabLayout.addTab(tabLayout.newTab().setText("Privacy"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorAccent));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected( TabLayout.Tab tab ) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected( TabLayout.Tab tab ) {

            }

            @Override
            public void onTabReselected( TabLayout.Tab tab ) {

            }
        });


        pager = findViewById(R.id.about_view_pager);
        if (pager != null) {
            pager.setAdapter(about_pagerAdapter);
        }
        assert pager != null;
        pager.setCurrentItem(tabLayout.getSelectedTabPosition());
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        back_home =findViewById(R.id.about_txt);
     back_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });




    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent upIntent = new Intent(this, HomeScreen.class);
          //      NavUtils.navigateUpTo(this, new Intent(this, HomeScreen.class));
                if (NavUtils.shouldUpRecreateTask(this, upIntent)){
                    TaskStackBuilder.from(this).addNextIntent(upIntent).startActivities();
                    finish();
                } else {
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;

        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
