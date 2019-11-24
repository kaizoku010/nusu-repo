/*
package com.wordpress.dixontechnologies.Mycashflow;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class NusuRepo {
    private CashRoomDao cashRoomDao;
    private ExpRoomDao expRoomDao;

private LiveData<List<CashItems>> allCashData;
private LiveData<List<ExpItems>> allExpData;
private double totalCash;
private int countCash;

public NusuRepo(Context context){
    NusuRoomDatabase roomDatabase = NusuRoomDatabase.getInstance(context);
    cashRoomDao = roomDatabase.getcashItems();
    totalCash = roomDatabase.getcashItems().getCashTotal();
    countCash = roomDatabase.getcashItems().getCashCount();
    expRoomDao = roomDatabase.getexpItems();
    this.allCashData = cashRoomDao.getCashItems_live();
    this.allExpData = expRoomDao.getExpItems();

}

            LiveData<List<CashItems>> getAllCashData(){return allCashData;}


        LiveData<List<ExpItems>> getAllxData(){
    return allExpData;
}

            double getTotalCash(){
    return totalCash;
}

            int getCountCash(){return countCash;
}

public void insertCash(CashItems cashItems){
            insertCashASYNC(cashItems);
}

public void insertExp(ExpItems expItems){
            insertExpAsync(expItems);
}

    private void insertCashASYNC(final CashItems cashItems) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    cashRoomDao.insertCash(cashItems);
*/
/*
                    insertResult.postValue(1);
*//*

                } catch (Exception e){
*/
/*
                    insertResult.postValue(0);
*//*

                e.printStackTrace();

                }
            }
        }).start();

}


    private void insertExpAsync(final ExpItems xItems) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    expRoomDao.insertExp(xItems);

                } catch (Exception e){

                e.printStackTrace();

                }
            }
        }).start();

}

private static class insertCashAsyncData extends AsyncTask<CashItems, Void, Void>{
            private CashRoomDao cashRoomDao_;
    insertCashAsyncData(CashRoomDao roomDao){
                cashRoomDao_ = roomDao;
            }

    @Override
    protected Void doInBackground(CashItems... cashItems) {

                cashRoomDao_.insertCash(cashItems[0]);
                return null;
    }

        public void deleteCash(CashItems cashItems){
                new deleteAsync(cashRoomDao_).execute(cashItems);
        }


    private class deleteAsync extends AsyncTask<CashItems, Void, Void>{

                private CashRoomDao cashRoomDaop;
                public deleteAsync(CashRoomDao cashRoomDao_) {
                cashRoomDaop = cashRoomDao_;

                }

        @Override
        protected Void doInBackground(CashItems... cashItems) {
            return null;
        }
    }
}
private static class insertx extends AsyncTask<ExpItems, Void, Void>{
            private ExpRoomDao xRoomDao_;
            insertx(ExpItems roomDaox){
                roomDaox = roomDaox;
            }

    @Override
    protected Void doInBackground(ExpItems... expItems) {

                xRoomDao_.insertExp(expItems[0]);
                return null;
    }

        public void deleteCash(ExpItems expItems){
                new deleteAsync(xRoomDao_).execute(expItems);
        }


    private class deleteAsync extends AsyncTask<ExpItems, Void, Void>{

                private ExpRoomDao xRoomDaop;
                public deleteAsync(ExpRoomDao xRoomDao_) {
                xRoomDaop = xRoomDao_;

                }

        @Override
        protected Void doInBackground(ExpItems... xItems) {
            return null;
        }
    }
}
}


*/
