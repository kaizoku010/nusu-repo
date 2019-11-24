
package com.wordpress.dixontechnologies.Mycashflow;

import java.util.ArrayList;

public interface NusuContract {

   interface View {
       void showProgressBar();
       void hideProgressBar();
       void showCashList();
       void showExpList();
       void showLoadingError(String errmsg);
       void getTotalCash();
       void getTotalCashCount();
       void getTotalExp();
       void getTotalExpCount();
   }

   interface Presenter{
       void loadCashViewList();
       void loadExpViewList();
       void dropView();
       void onError(String errmsg);
   }

   interface onResponseCallBack{
       void onResponse(ArrayList<Entry_Nusu_Ojo> list);
       void onError(String errmsg);
   }

}
