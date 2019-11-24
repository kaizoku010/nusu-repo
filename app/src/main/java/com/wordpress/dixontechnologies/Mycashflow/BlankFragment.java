/*
package com.wordpress.dixontechnologies.Mycashflow;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.chip.Chip;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Gallery;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.wordpress.dixontechnologies.Mycashflow.data.DBAdapter;
*/
/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 *//*

public class BlankFragment extends Fragment {
    TextView balance_tv;
    TextView total_cash;
    SharedPreferences sharedPreferences;
   // ProgressBar progressBar;
    //AvatarImageView avatarImageView;
    private Chip chip;


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        sharedPreferences =
                PreferenceManager.
                        getDefaultSharedPreferences(getContext());

        View view_ = inflater.inflate(R.layout.appname_version, container, false);

    //    balance_tv = view_.findViewWithTag("#balance_totals");
        balance_tv = view_.findViewById(R.id.real_bal);
  //      avatarImageView = view_.findViewWithTag("#avatar_dixon");
        Resources res = getResources();
         chip = view_.findViewById(R.id.nusu_avatar);
         chip.setText("Balance");
         chip.setChipIcon(ContextCompat.getDrawable(requireContext(), R.mipmap.nusu_logo));

        setAvatar();

*/
/*//*
/cash-exp = balance.
* int old_balance = balance
* int new_balance = old_balance.
* if (old_balance >= new_balance){
*           pStat+=1;
*           }
* *//*



     //  setUpInfo();
        return view_;
    }

    private void setAvatar() {

        DBAdapter adapter = new DBAdapter(getContext());
        adapter.openDB();
        double cash = adapter.getTotalCash();
        double exp = adapter.getTotalExpenses();

        final double balance_ = cash - exp;

        if (balance_ >= 0){
            String bal_ = String.valueOf(balance_);
            balance_tv.setText(bal_);
        } else {
            balance_tv.setText("No Data");
        }
        adapter.closeDB();


    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
*/
/*
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
*//*

    }

    @Override
   public void onDetach() {
        super.onDetach();

    }

    */
/**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.ugby com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     *//*

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



}
*/
