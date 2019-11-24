package com.wordpress.dixontechnologies.Mycashflow;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CurrencySlide.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CurrencySlide#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CurrencySlide extends Fragment implements AdapterView.OnItemSelectedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int layoutResId = R.layout.fragment_currency_slide;
    private static String ARG_LAYOUT_RES_ID = "layoutResId";

    private OnFragmentInteractionListener mListener;


    Mcf_Currencies[] mcf_CurrenciesAll ={
            new Mcf_Currencies("UGX", "UGANDA SHILLINGS"),
            new Mcf_Currencies("$", "DOLLARS"),
            new Mcf_Currencies("Kshs", "KENYA SHILLINGS"),
            new Mcf_Currencies("Tshs", "TANAZANIA SHILLINGS"),
            new Mcf_Currencies("£", "POUNDS"),
            new Mcf_Currencies("", "AFGANI"),
            new Mcf_Currencies("৲", "BENGALI RUPEE MARK"),
            new Mcf_Currencies("૱", "GUJARATI RUPEE"),
            new Mcf_Currencies("௹", "TAMIL RUPEE"),
            new Mcf_Currencies("฿", "THAI BAHT"),
            new Mcf_Currencies("¤", "KHMER "),
            new Mcf_Currencies("", "RIEL"),
            new Mcf_Currencies("₠", "EURO-CURRENCY"),
            new Mcf_Currencies("₡", "COLON"),
            new Mcf_Currencies("₢", "CRUZEIRO"),
            new Mcf_Currencies("₣", "FRENCH FRANC "),
            new Mcf_Currencies("₤", "LIRA"),
            new Mcf_Currencies("₥", "MILL"),
            new Mcf_Currencies("₦", "NAIRA"),
            new Mcf_Currencies("₧", "PESETA"),
            new Mcf_Currencies("₨", "RUPEES "),
            new Mcf_Currencies("₩", "WON"),
            new Mcf_Currencies("₪", "NEW SHEQEL"),
            new Mcf_Currencies("₫", "DONG"),
            new Mcf_Currencies("€", "EURO"),
            new Mcf_Currencies("₭", "KIP"),
            new Mcf_Currencies("₮", "TUGRIK"),
            new Mcf_Currencies("₯", "DRACHMA"),
            new Mcf_Currencies("₰", "GERMAN PENNY"),
            new Mcf_Currencies("₱", "PESO"),
            new Mcf_Currencies("₲", "GUARANI"),
            new Mcf_Currencies("₳", "AUSTRAL"),
            new Mcf_Currencies("₴", "HRYVNIA"),
            new Mcf_Currencies("₵", "CEDI"),
            new Mcf_Currencies("₶", "LIVRE TOURNOIS"),
            new Mcf_Currencies("₷", "SPESMILO"),
            new Mcf_Currencies("₸", "TENGE"),
            new Mcf_Currencies("₹", "INDIAN RUPEE"),
            new Mcf_Currencies("₺", "TURKISH LIRA")
    };
    private View v;
    private Spinner spinner;
    private TextView textView1;
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;


    public CurrencySlide() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CurrencySlide newInstance(int layoutResId) {
        CurrencySlide fragment = new CurrencySlide();
        Bundle args = new Bundle();
        args.putInt(ARG_LAYOUT_RES_ID, layoutResId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(ARG_LAYOUT_RES_ID)) {
            layoutResId = getArguments().getInt(ARG_LAYOUT_RES_ID);
        }
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_currency_slide, container, false);
        Spinner_CurrenciesAdapter spinner_currenciesAdapter
                = new Spinner_CurrenciesAdapter(getContext(),
                                mcf_CurrenciesAll);

        spinner = v.findViewById(R.id.spinner__);
        spinner.setAdapter(spinner_currenciesAdapter);
        spinner.setOnItemSelectedListener(this);
        //   spinner.setSelection(sharedPreferences.getString("currency_", ""));
        return v;
    }

    // TODO: Rename method,3 update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

//
//    AdapterView.OnItemClickListener onItemSelected
//            = new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            Mcf_Currencies mcf_currencies = (Mcf_Currencies) parent.getItemAtPosition(position);
//            String reslt = mcf_currencies.getSymbol();
//            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
//            sharedPreferences.edit().putString("currency_", reslt).apply();
//        }
//    };

    @Override
    public void onDetach() {

        super.onDetach();
        mListener = null;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        mcf_CurrenciesAll = new Mcf_Currencies[position];
        String userCurrencyChoice = mcf_CurrenciesAll[position].getSymbol();
     SharedPreferences  sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor   editor = sharedPreferences.edit();
        editor.putString("currency_", userCurrencyChoice);
        editor.apply();
        spinner.setSelection(position, true);
     //   Toast.makeText(getContext(), "works..."+userCurrencyChoice, Toast.LENGTH_SHORT).show();



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
