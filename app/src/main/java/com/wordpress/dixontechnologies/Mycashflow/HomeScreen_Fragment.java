/*
package com.wordpress.dixontechnologies.Mycashflow;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;
import com.wordpress.dixontechnologies.Mycashflow.data.Constants;
import com.wordpress.dixontechnologies.Mycashflow.data.DBAdapter;

import org.fabiomsr.moneytextview.MoneyTextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import babushkatext.BabushkaText;
import lecho.lib.hellocharts.view.ColumnChartView;

*/
/**
 * Created by ${Dixon} on 2/24/2017.
 * this shld hold our graph
 *
 *//*

public class HomeScreen_Fragment extends Fragment{

//    i decided to use a frag for the home screen coz
//    i can reuse these views or maybe some of them
//            it also srinks my code to be more clear



    private static final
    String[] WEEK_DAYS = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};

    private static final String PREFS_NAME = "spinnerState";
    private View homeScreen_view_frag;
    private TextView textView_total_cash;
    private TextView textView_total_exp;
    private TextView textView_grandTotal;
    private MoneyTextView dollars_textview;
    private TextView spinner_mulla;
    private DecimalFormat decimalFormat;
    private static final String TAB_POSITION = "tab_position" ;
    private TextView maxed_data;
    private ColumnChartView ccv;
    FloatingActionButton fav;
        GraphView graphview;
    DBAdapter db;
    Context context = getContext();
    Date date;

    private DateFormat dateFormat;
    private DateAsXAxisLabelFormatter dateAsXAxisLabelFormatter;
    private FloatingActionButton sharedFab;
    private Calendar calendar;
    private int days;
    private Date date__;
    private LineGraphSeries<DataPointInterface> lineGraphSeries;


    public static HomeScreen_Fragment newInstance(int tabPosition) {
        HomeScreen_Fragment fragment = new HomeScreen_Fragment();
        Bundle args = new Bundle();
        args.putInt(HomeScreen_Fragment.TAB_POSITION, tabPosition);
        fragment.setArguments(args);
        return fragment;



    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {




        db = new DBAdapter(getActivity());

        homeScreen_view_frag = inflater.inflate(R.layout.homescreen_frag_view, container, false);

        initializingView();
        GraphView  graphview = homeScreen_view_frag.findViewById(R.id.line_chart);


     LineGraphSeries  lineGraphSeries = new LineGraphSeries<>(getChartData());


      settingUpSummary();










        calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        BarGraphSeries barGraphSeries = new BarGraphSeries<>(getExpChart());




        date__ = calendar.getTime();
        lineGraphSeries.setDrawDataPoints(true);
        lineGraphSeries.setDataPointsRadius(10);
        lineGraphSeries.setTitle("cash values");
        lineGraphSeries.setThickness(6);
        lineGraphSeries.setColor(getResources()
                .getColor(R.color.yellow));
        //  lineGraphSeries.setBackgroundColor(R.color.colorAccent);

        lineGraphSeries.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPointInterface) {
                Toast.makeText(getActivity(), "Cash Item :"
                        + dataPointInterface, Toast.LENGTH_LONG).show();

            }


        });

        graphview.addSeries(lineGraphSeries);


        barGraphSeries.setColor(getResources()
                .getColor(R.color.new_red));
        barGraphSeries.setDrawValuesOnTop(true);
        barGraphSeries.setDataWidth(5);
        barGraphSeries.setSpacing(10);
        barGraphSeries.setDrawValuesOnTop(true);
        barGraphSeries.setValuesOnTopColor(Color.RED);


        graphview.addSeries(barGraphSeries);
        graphview.setTitle("Entries Over Time");


        date = new Date();
        date = calendar.getTime();

        graphview.getViewport().setXAxisBoundsManual(true);
                dateFormat = new SimpleDateFormat("EEE", Locale.getDefault());

        StaticLabelsFormatter labelsFormatter
                = new StaticLabelsFormatter(graphview);
        labelsFormatter.setHorizontalLabels(WEEK_DAYS);
        graphview.getGridLabelRenderer().setLabelFormatter(labelsFormatter);



        LegendRenderer legendRenderer = new LegendRenderer(graphview);
        legendRenderer.setVisible(true);
        legendRenderer.setBackgroundColor(getResources().getColor(R.color.whiteTextColor));


        graphview.setLegendRenderer(legendRenderer);

        graphview.getViewport().setYAxisBoundsManual(true);
        graphview.getGridLabelRenderer().setNumHorizontalLabels(7);
       //    graphView.getGridLabelRenderer().setNumVerticalLabels(10);



        graphview.getViewport().setXAxisBoundsStatus(Viewport.
                AxisBoundsStatus.AUTO_ADJUSTED);



        graphview.getGridLabelRenderer().setHumanRounding(false);

//        PreferenceManager preferenceManager = new PreferenceManager(getContext());
*/
/*
        SharedPreferences saveSpinnerCurrenceny = getActivity().getSharedPreferences(PREFS_NAME, 0);
        Spinner_CurrenciesAdapter currenciesAdapter = new Spinner_CurrenciesAdapter(getContext(), Mcf_CurrenciesAll);
        currenciesAdapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_2);
        spinner_mulla.setAdapter(currenciesAdapter);
        spinner_mulla.setSelection(saveSpinnerCurrenceny.getInt("spinnerPos", 0));
        spinner_mulla.setOnItemSelectedListener(onitemSelectedListener);
        spinner_mulla.setBackgroundColor(getResources().getColor(R.color.white_bj));*//*


        //finding all view
           showTotalCash();
          showTotalExp();


        return homeScreen_view_frag;
    }

    private void settingUpSummary() {

        db.openDB();
        double totalcashh = db.getTotalCash();
        double totalExp = db.getTotalExpenses();
        int cashCount = db.getCashRow_count();
        int expCount = db.getExpRow_count();
        double balo = totalcashh - totalExp;
        db.closeDB();

        TextView cashSummary = homeScreen_view_frag.findViewById(R.id.cash_summary);
        TextView expSummary = homeScreen_view_frag.findViewById(R.id.exp_summary);
        TextView majorBalanc = homeScreen_view_frag.findViewById(R.id.balance_);

        if (totalcashh == 0  &&  totalExp == 0){
            cashSummary.setText("No Data to Display");
            expSummary.setVisibility(View.GONE);
            majorBalanc.setVisibility(View.GONE);

        } else {
            cashSummary.setText("TotalCash :" + totalcashh + "\n" + "Last month cash items:" + "("+cashCount+" )");
            expSummary.setText("TotalExpenses :" + totalExp + "\n" + "Total number of expenses :" + "("+expCount+")");


            majorBalanc.setText("Balance :" +balo);
            majorBalanc.setVisibility(View.VISIBLE);
            expSummary.setVisibility(View.VISIBLE);
        }



    }



   */
/* @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //getting spinner d= v..ata from setting activity to home_screen textview.
        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(getContext());
        String currencies_ = preferences.getString("MULLA_LIST", "no selection");
        spinner_mulla.setText(currencies_);
      //  data.getExtras().getBundle("MULLA_LIST");


   //     chartdata();

        PreferenceManager preferenceManager = new PreferenceManager(getContext());
//        preferenceManager.
*//*

  //  }





    //bridging all views
    private void initializingView() {

        //dollars_textview = (MoneyTextView) homeScreen_view_frag.findViewById(R.id.how_much_left2);
        textView_total_cash = (BabushkaText) homeScreen_view_frag.findViewById(R.id.total_cash_txt);
        textView_total_exp = (BabushkaText) homeScreen_view_frag.findViewById(R.id.total_exp_txt);
        textView_grandTotal = (BabushkaText) homeScreen_view_frag.findViewById(R.id.balance);
   //   maxed_data = (BabushkaText) homeScreen_view_frag.findViewById(R.id.txtView_max);

        //BabushkaText babushkaText =  new BabushkaText(getContext());


    }

    private DataPoint[] getChartData() {

        db = new DBAdapter(getContext());


        db.openDB();

        Cursor cursor_cash = db.getchartdata();
        DataPoint[] dataPoints = new DataPoint[cursor_cash.getCount()];

            while(cursor_cash.moveToNext()){
                // this is custom..plotting totals over 8 days

                double amount__ = db.getTotalCash();

              long cash_time_ =
                        (new Date(cursor_cash.getLong(cursor_cash.
                                getColumnIndex(Constants.DATE_NAME)))
                                .getTime());


               dataPoints[cursor_cash.getPosition()] = new DataPoint(cash_time_ + (cursor_cash.getPosition()
                                * 60 * 60 * 24 * 1000), amount__);


                */
/*dataPoints[cursor_cash.getPosition()] =
                        new DataPoint((cursor_cash.getPosition()), amount__);
*//*

            }


            cursor_cash.close();
        db.closeDB();
        return dataPoints;

    }



    private long cash__date(){

        long cash_time;
        long test = 0;

        db = new DBAdapter(getContext());
        db.openDB();
        Cursor cursor = db.retrieve();
        for (int i = 0; i<cursor.getCount(); i++) {

            cursor.moveToLast();

            cash_time = (new Date(cursor.getLong(cursor.
                                    getColumnIndex(Constants.DATE_NAME))).getTime());

        }

            return test;


    }



    private DataPoint[] getExpChart() {

        db = new DBAdapter(getContext());


        db.openDB();

        Cursor cursor_exp = db.getExpchartdata();
        DataPoint[] dataPoints = new DataPoint[cursor_exp.getCount()];


        while(cursor_exp.moveToNext()) {
            double cost__ =
                    cursor_exp.getDouble
                            (cursor_exp.getColumnIndex
                                    (Constants.KEY_EXPENSES));

            long exp_time =
                    (new Date(cursor_exp.getLong(cursor_exp.
                            getColumnIndex(Constants.EXP_DATE)))
                            .getTime());

            dataPoints[cursor_exp.getPosition()] = new DataPoint(
                    exp_time + (cursor_exp.getPosition()
                            * 60 * 60 * 24 * 1000), cost__);

        }

        cursor_exp.close();
            db.closeDB();
    return  dataPoints;
    }


    private void pullingData(String textCheck) {
//testing spinner selection from the setting activity if it can change or affect others views/
// sharedprefs from the pref/screen/




        db.openDB();
        double grandtotal = (db.getTotalCash() - db.getTotalExpenses() );



        if (textCheck.length()<14) {

            dollars_textview.setVisibility(View.VISIBLE);
            textView_grandTotal.setVisibility(View.INVISIBLE);
            dollars_textview.setAmount(Float.valueOf(String.valueOf(grandtotal)));


        } else if (textCheck.contains("Shillings")) {

            dollars_textview.setVisibility(View.INVISIBLE);
            textView_grandTotal.setVisibility(View.VISIBLE);
            decimalFormat = new DecimalFormat("###,###,###");
            decimalFormat.setDecimalSeparatorAlwaysShown(true);

            textView_grandTotal.setText(decimalFormat.format(grandtotal));
            if (grandtotal <= -1){
                textView_grandTotal.setTextColor(getResources().getColor(R.color.red));


            } else textView_grandTotal.setTextColor(getResources().getColor(R.color.that_light_green));

            textView_grandTotal.setText(decimalFormat.format(grandtotal));
        }
        db.closeDB();





    }

    private String showTotalCash() {
        decimalFormat = new DecimalFormat("#,###.00");

        db.openDB();

        String amount = (String.valueOf((db.getTotalCash())));

        // String cash_only = String.format("%.2f", db.getTotalCash());
        //   textView_total_cash.setText(cash_only);
        double cash_amount = Double.parseDouble(amount);
            String cash_format = decimalFormat.format(cash_amount);
//        textView_total_cash.setText(cash_format);
        //        textView_total_cash.setText(expAdapter.sumOfCashValuesFromDB());
        db.closeDB();
        return cash_format;

    }
    private void showTotalExp(){
        decimalFormat = new DecimalFormat("#,###.00");

        //decimalFormat.getCurrency(Character.UnicodeBlock.CURRENCY_SYMBOLS);
        DBAdapter db = new DBAdapter(getContext());
        db.openDB();
        // String exp_only = String.format("%.2f", db.getTotalExpenses());
        // textView_total_exp.setText(exp_only);

        String cost = (String.valueOf((db.getTotalExpenses())));
        double exp_amount = Double.parseDouble(cost);
        String exp_format = decimalFormat.format(exp_amount);
       //textView_total_exp.setText(exp_format);
        db.closeDB();
    }

  */
/*  private void sharedPrefs() {


        (new Handler()).post(new Runnable() {
            @Override
            public void run() {

                pullingData(textCheck);
                DBAdapter db = new DBAdapter(getContext());
                db.openDB();
                String grand_total = (String.valueOf(db.getTotalCash() - db.getTotalExpenses() + " "));

                if (spinner_mulla.getSelectedItemPosition() > 4) {

                    dollars_textview.setVisibility(View.VISIBLE);
                    textView_grandTotal.setVisibility(View.INVISIBLE);
                    dollars_textview.setAmount(Float.valueOf(grand_total));

                    db.closeDB();



                } else if (spinner_mulla.getSelectedItemPosition() <= 5) {

                    dollars_textview.setVisibility(View.INVISIBLE);
                    textView_grandTotal.setVisibility(View.VISIBLE);

                    dollars_textview.setVisibility(View.INVISIBLE);
                    textView_grandTotal.setVisibility(View.VISIBLE);
                    decimalFormat = new DecimalFormat("###,###,###");
                    decimalFormat.setDecimalSeparatorAlwaysShown(true);

                    double balance = Double.parseDouble(grand_total);
                    textView_grandTotal.setText(decimalFormat.format(balance));

                }
                db.closeDB();


            }
        });
    }*//*


*/
/*            // my custom adapterView
    private final AdapterView.OnItemSelectedListener onitemSelectedListener;

    {
        onitemSelectedListener = new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sharedPrefs();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
    }*//*

//    private SharedPreferences getSharedPreferences(String spinnerState, int i) {
//        return getSharedPreferences("spinnerState", 0);
//    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onStop() {
        super.onStop();
        */
/*int userCurrencyChoice = spinner_mulla.getSelectedItemPosition();
        SharedPreferences saveSpinnerCurrenceny = getActivity().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor edissa = saveSpinnerCurrenceny.edit();
        edissa.putInt("spinnerPos", userCurrencyChoice);
        edissa.apply();*//*



    }

    @Override
    public void onStart() {


        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();

        //sharedPrefs();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        sharedFab = null;
    }

    public void setSharedFab(FloatingActionButton fab){
        if(fab == null) {
            if (sharedFab != null) {
                sharedFab.setOnClickListener(null);
            }
            sharedFab = null;
        } else {

            sharedFab = fab;
        //    theme = getResources().getResourceName(R.xml);
            Activity activity = getActivity();
            if (activity !=null && isAdded())
            sharedFab.setBackgroundColor(getResources().getColor(R.color.fab_bright*/
/*, theme*//*
));
        }



    }



//
//        //reduced our dialogs to one so that we make space for the awesome panels...jeahhhh!!
//    private void open_entry_dialog() {
//
//        entry_type_dialog = new Dialog(context);
//        entry_type_dialog.setTitle("ADD ITEM");
//        entry_type_dialog.setContentView(R.layout.entry_type_dialog);
//
//        //opening the open cash dialog
//        open_cash_panel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //opening the cash panel
//                mcf_cash_bottomSheet_panel();
//            }
//        });
//
//        //opening the exp dialog
//        open_exp_panel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                exp_bottomSheet_panel();
//            }
//        });
//        entry_type_dialog.show();
//
//
//    }
//
    //i dont think we shall need this
//    private void swipeRefreshLayout_meth() {
//        swipeRefreshLayout = (my_swipeRefreshLayout)homeScreen_view_frag.findViewById(R.id.swiperefresh_main);
//
//
//        (new Handler()).post(new Runnable() {
//            @Override
//            public void run() {
//
//                swipeRefreshLayout.setRefreshing(true);
//                swipeRefreshLayout.setColorSchemeResources(R.color.black, R.color.yellow, R.color.red);
//
//                pullingData();
//                //showing total sum of cash entries from the database to the HomeScreen.
//                showTotalCash();
//                //showing total sum of expenses from the database to the HomeScreen.
//                showTotalExp();
//                //this is to refresh the fragments content, including displaying the recyclerView.
//                //tablayout_viewPager();
//
//
//                (new Handler()).postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        swipeRefreshLayout.setRefreshing(false);
//                    }
//                }, 3000);
//            }
//        });
//
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//
//                refreshTabs();
//
//                pullingData();
//                //showing total sum of cash entries from the database to the HomeScreen.
//                showTotalCash();
//                //showing total sum of expenses from the database to the HomeScreen.
//                showTotalExp();
//                //this is to refresh the fragments content, including displaying the recyclerView.
//                refreshTabs();
//
//
//                (new Handler()).postDelayed(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        swipeRefreshLayout.setRefreshing(false);
//                        //   swipeRefreshLayout.setColorSchemeResources(R.color.black, R.color.yellow, R.color.red);
//
//                    }
//
//
//                }, 5000);
//            }});
//
//    }



    public class GridAdapter extends BaseAdapter {
        public LayoutInflater layoutInflater = null;


public GridAdapter(int sumValues ){
    layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


}

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null)
                view = layoutInflater.inflate(R.layout.nusu_slide_intro, null);
            BabushkaText total_cash = (BabushkaText) view.findViewById(R.id.total_cash_view);
            BabushkaText total_exp = (BabushkaText) view.findViewById(R.id.total_exp);
            BabushkaText balance = (BabushkaText) view.findViewById(R.id.balance);
           */
/* BabushkaText total_cash = (BabushkaText) view.findViewById(R.id.total_exp);
            BabushkaText total_cash = (BabushkaText) view.findViewById(R.id.total_exp);
            BabushkaText total_cash = (BabushkaText) view.findViewById(R.id.total_exp);*//*



            decimalFormat = new DecimalFormat("#,###.00");

            db.openDB();

            String amount = (String.valueOf((db.getTotalCash())));

            // String cash_only = String.format("%.2f", db.getTotalCash());
            //   textView_total_cash.setText(cash_only);
            double cash_amount = Double.parseDouble(amount);
            String cash_format = decimalFormat.format(cash_amount);
//        textView_total_cash.setText(cash_format);
            //        textView_total_cash.setText(expAdapter.sumOfCashValuesFromDB());
            String exp_amount = (String.valueOf((db.getTotalExpenses())));

            // String cash_only = String.format("%.2f", db.getTotalCash());
            //   textView_total_cash.setText(cash_only);
            double _amount = Double.parseDouble(exp_amount);
            String _format = decimalFormat.format(_amount);
//        textView_total_cash.setText(cash_format);
            //        textView_total_cash.setText(expAdapter.sumOfCashValuesFromDB());



//totals from db
            total_cash.setText(cash_format);
            total_exp.setText(_format);

            //cash balance
            double balance_ = cash_amount - _amount;
            String balance_strng = decimalFormat.format(balance_);
            balance.setText(balance_strng);


            db.closeDB();
            return view;
        }
    }


}
*/
