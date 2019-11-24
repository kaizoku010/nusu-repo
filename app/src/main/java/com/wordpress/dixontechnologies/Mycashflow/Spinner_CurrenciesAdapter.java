package com.wordpress.dixontechnologies.Mycashflow;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${Dixon} on 2/24/2017.
 */
class Spinner_CurrenciesAdapter extends ArrayAdapter<Mcf_Currencies> {

    private Mcf_Currencies[] mcf_currencies;

    Spinner_CurrenciesAdapter(Context context, Mcf_Currencies[]
            myCurrenciesAll) {
        super(context, R.layout.spinner_row, myCurrenciesAll);
        this.mcf_currencies = myCurrenciesAll;
    }


    @Override
    public int getCount() {
        return mcf_currencies.length;
    }


    @Override
    public Mcf_Currencies getItem(int position) {
        return mcf_currencies[position];
    }


    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        observer.equals(mcf_currencies);
    }


    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        observer.equals(mcf_currencies);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
//        Mcf_Currencies mcf_currencies = getItem(position);
//
//        View view;
//        view = View.inflate(_c_, R.layout.dropdead, null );
//
//        TextView spinner_text_one = view.findViewById(R.id.textSymbol);
//        spinner_text_one.setText(mcf_currencies.getSymbol());
//            TextView spinner_text_two = view.findViewById(R.id.textDesc);
//            spinner_text_two.setText(mcf_currencies.getDesc());
//                    return view;
                return getCustomDropView(position, convertView, parent);
    }

    private View getCustomDropView(int position, View convertView, ViewGroup parent) {
        Mcf_Currencies mcf_currencies = getItem(position);
        LayoutInflater layoutInflater = ( LayoutInflater) getContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
        );

        convertView= layoutInflater.inflate(R.layout.dropdead, null );
        TextView spinner_text_one = convertView.findViewById(R.id.textSymbol);
        spinner_text_one.setText(mcf_currencies.getSymbol());
            TextView spinner_text_two = convertView.findViewById(R.id.textDesc);
            spinner_text_two.setText(mcf_currencies.getDesc());
                    return convertView;
    }

    private View getCustomView(int position, View convertView,
                               ViewGroup parent) {
        LayoutInflater layoutInflater = ( LayoutInflater) getContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
        );
        convertView = layoutInflater.inflate(R.layout.spinner_row, parent, false);
        TextView textView = convertView.findViewById(R.id.spinner_data);
        textView.setText(mcf_currencies[position].getSymbol());
        return convertView;


    }


    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        if(convertView == null){
//            convertView = LayoutInflater.from(_c_).inflate(
//                    R.layout.spinner_row, parent, false
//            );
//        }
//        TextView textView1 =  convertView.findViewById(R.id.spinner_data);
//        if (position <= 0){
//            textView1.setText("Ooops..!");
//        } else
//        textView1.setText(mcf_currencies[position].getDesc());
////
////        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(_c_);
////        SharedPreferences.Editor editor = sharedPreferences.edit();
////        editor.putString("currency_", val);
////        editor.apply();
//
////        val = mcf_currencies[position].getDesc();
//        return convertView;
   return getCustomView(position, convertView, parent);

    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

}

