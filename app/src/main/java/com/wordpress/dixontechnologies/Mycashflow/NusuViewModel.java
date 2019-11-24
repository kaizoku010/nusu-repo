/*
package com.wordpress.dixontechnologies.Mycashflow;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

*/
/**
 * Created by ${Dixon} on 2/3/2018.
 *//*


public class NusuViewModel extends AndroidViewModel {

  private NusuRepo nusuRepo;
  private LiveData<List<CashItems>> insertCashLiveData;
  private double cashTotal;
  private int cashCount;
  private LiveData<List<ExpItems>> insertExpLiveData;



    public NusuViewModel(@NonNull Application application) {
        super(application);
        nusuRepo = new NusuRepo(application);
        insertCashLiveData = nusuRepo.getAllCashData();
        cashTotal = nusuRepo.getTotalCash();
        cashCount = nusuRepo.getCountCash();
        insertExpLiveData = nusuRepo.getAllxData();
    }

    public void insertCash(CashItems cashItems){
        nusuRepo.insertCash(cashItems);
    }

    public LiveData<List<CashItems>> getinsertCashLiveData(){
        return insertCashLiveData;
    }
    public LiveData<List<ExpItems>> getinsertxLiveData(){
        return insertExpLiveData;
    }

    public double getCashTotal(){
        return cashTotal;
    }
    public int getCashCount(){
        return cashCount;
    }

    public void insertExp(ExpItems expItems){
        nusuRepo.insertExp(expItems);
    }


}
*/
