/*
 * Copyright (c) $November 18th.2019. Property Of Muneza Dixon.
 */

package com.wordpress.dixontechnologies.Mycashflow;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.events.DecoEvent;
import com.startapp.android.publish.ads.banner.Banner;
import com.startapp.android.publish.ads.banner.BannerListener;
import com.startapp.android.publish.ads.banner.BannerOptions;
import com.startapp.android.publish.ads.banner.banner3d.Banner3D;
import com.startapp.android.publish.ads.nativead.NativeAdPreferences;
import com.startapp.android.publish.ads.nativead.StartAppNativeAd;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.common.model.AdPreferences;
import com.wordpress.dixontechnologies.Mycashflow.data.DBAdapter;
import com.wordpress.dixontechnologies.Mycashflow.listeners.RichListener;

import org.fabiomsr.moneytextview.MoneyTextView;

import java.util.ArrayList;
import java.util.Iterator;

public class NusuArc extends Fragment implements RichListener {

    NativeAdPreferences nativeAdPreferences;
    StartAppNativeAd startAppNativeAd;
    private View v;
    MoneyTextView cash_total, exp_total;
    private static final String TAB_POSITION = "tab_position";
    private DBAdapter dbAdapter;
    // --Commented out by Inspection (11/13/2019 12:41 PM):private double cash_total_, exp_nusu;
    private final float max_val = 10000;
    private DecoView decoView_cash_total_arc;
    private DecoView decoView_exp_total_arc;
    private String currency_type;
    private TextView tits4_cas;
    private TextView tits2;
    private LinearLayout root;
    private RelativeLayout relative;
    private LinearLayout.LayoutParams _root;
    private RelativeLayout.LayoutParams relative_root_paras;
    private AdEventListener adEventListener;

    public static Fragment newInstance(int position) {
        NusuArc fragment = new NusuArc();
        Bundle args = new Bundle();
        args.putInt(NusuArc.TAB_POSITION, position);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.middle_view_frag, container, false);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
     currency_type = sharedPreferences.getString("currency_", "");
    decoView_cash_total_arc = v.findViewById(R.id.nusu_cash_arc);
        decoView_exp_total_arc = v.findViewById(R.id.nusu_exp_arc);
        tits4_cas = v.findViewById(R.id.tits4);
        tits2 = v.findViewById(R.id.tits2);
        root = v.findViewById(R.id.line__);
        relative = new RelativeLayout(getContext());
        startAppNativeAd = new StartAppNativeAd(getContext());

//        tits4_cas.setText(cashCount()+" "+"Cash Items");
//        tits2.setText(expCount()+" "+"Cash Items");
   //setad();
        relative_root_paras = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        Banner3D banner3D = v.findViewById(R.id.ad__);
//        startAppNativeAd.loadAd();
    nativeAdPreferences = new NativeAdPreferences()

                .setAdsNumber(1)
                .setAutoBitmapDownload(true)
                .setPrimaryImageSize(2);

    adEventListener = new AdEventListener() {
            @Override
            public void onReceiveAd(Ad ad) {
                banner3D.onReceiveAd(ad);
                banner3D.showBanner();

                ArrayList ads = startAppNativeAd.getNativeAds();    // get NativeAds list
                Iterator iterator = ads.iterator();
                while (iterator.hasNext()){
                    Log.d("TAG__AD", iterator.next().toString());
                }

            }

            @Override
            public void onFailedToReceiveAd(Ad ad) {

            }
        };
    /*relative.addView(banner3D, relative_root_paras);
    root.addView(relative, 0);
*/
        setupViews();
        textCount();
        return v;
    }

    private void setad() {
        /*startAppNativeAd = new StartAppNativeAd(getContext());
        startAppNativeAd.loadAd(nativeAdPreferences, adEventListener);
*/
        _root = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        Banner banner = new Banner(getActivity());
        banner.setBannerListener(new BannerListener() {
            @Override
            public void onReceiveAd(View view) {
                    banner.addView(view);
                Toast.makeText(getContext(), "WORRRKKKKS", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailedToReceiveAd(View view) {
                Toast.makeText(getContext(), ":((:(:(:(:(", Toast.LENGTH_LONG).show();


            }

            @Override
            public void onClick(View view) {

            }
        });

//        root.addView(banner, _root);

    }

    private void setupViews() {
        cash_total = v.findViewById(R.id.cash_tots);
        exp_total = v.findViewById(R.id.exp_tots);
        setupMoreViews(cash_total, exp_total);
        setUpCash_total_arc(decoView_cash_total_arc);
        setUpExp_total_arc(decoView_exp_total_arc);
    }

    //purple arc
    private void setUpExp_total_arc(DecoView decoView_cash_total_arc) {

        final SeriesItem exp_total_arc_series = new SeriesItem.Builder(Color.parseColor("#F75A5A"))
                .setRange(0, max_val, 0).build();

        int exp_total_arc = decoView_cash_total_arc.addSeries(exp_total_arc_series);
        decoView_cash_total_arc.addEvent(new DecoEvent.Builder(exp_total_arc()).setIndex(exp_total_arc).build());
//decoView_cash_total_arc.

    }


    //inner/1st yellow arc
    private void setUpCash_total_arc(DecoView decoView_cash_total_arc) {

        final SeriesItem seriesItem = new SeriesItem.Builder(Color.parseColor("#FFA340"))
                .setRange(0, max_val, 0)
                .build();

        int cash_index = decoView_cash_total_arc.addSeries(seriesItem);
        decoView_cash_total_arc.addEvent(new DecoEvent.Builder(cash_total_arc())
                .setIndex(cash_index)
                .build());
    }


    public void textCount(){
        if (cashCount() <= 0){
            tits4_cas.setText("No Cash Items");
        }else {
            tits4_cas.setText(cashCount()+" "+ "Cash Items");
        }
        if (expCount() <=0){
            tits2.setText("No Exp Items");
        }else {
            tits2.setText(expCount()+ " " + "Exp Items" );
        }
    }
    private int cashCount() {

        dbAdapter.openDB();
        int cash_count = dbAdapter.getCashRow_count();

        if (cash_count >= 0) {
            return cash_count;
        }
        dbAdapter.closeDB();

        return cash_count;

    }

    private int expCount() {

        dbAdapter.openDB();
        int exp_count = dbAdapter.getExpRow_count();

        if (exp_count >= 0) {
            return exp_count;
        }
        dbAdapter.closeDB();
        return exp_count;
    }



    public double setCash_total() {
        double cashTotal;
        dbAdapter = new DBAdapter(getContext());
        dbAdapter.openDB();
        cashTotal = dbAdapter.getTotalCash();
        dbAdapter.closeDB();

            return cashTotal;
    }

    public double setExp_total() {

        double expTotal;

        dbAdapter = new DBAdapter(getContext());
        dbAdapter.openDB();
        expTotal = dbAdapter.getTotalExpenses();
        dbAdapter.closeDB();

        return expTotal;
    }

    private float cash_total_arc() {

        float a = 5f;
        if (setCash_total() > setExp_total()) {
            a += 300.0f;
            return a;
        } else if (setCash_total() < setExp_total()) {
            a -= 50.0f;
            return a;
        }
        return a;
    }


    private float exp_total_arc() {
        float b = 5f;
            if (setExp_total() > cash_total_arc()) {
                b += 300.0f;
                return b;
            } else if (setExp_total() < cash_total_arc()) {
                b -= 50.0f;
                return b;

        }
        return b;
    }


    private void setupMoreViews(MoneyTextView cash_total,
                                MoneyTextView exp_total) {

            String str_cash = String.valueOf(setCash_total());
            String str_exp = String.valueOf(setExp_total());

        cash_total.setAmount(Float.parseFloat(str_cash), currency_type);
        exp_total.setAmount(Float.parseFloat(str_exp), currency_type);
    }

    @Override
    public void updateUi(DBAdapter nusu_ojo) {
        dbAdapter = nusu_ojo;
    }
}
