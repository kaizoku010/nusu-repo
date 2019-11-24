/*
package com.wordpress.dixontechnologies.Mycashflow;

public final class NusuPresenter implements NusuContract.Presenter {

    private  NusuContract.View view;
    private NusuRepo mCashRepo;
    private NusuContract.onResponseCallBack callback;


    public NusuPresenter(NusuContract.View view, NusuRepo cashRepo){
       this.view = view;
       mCashRepo = cashRepo;

   }

    @Override
    public void loadCashViewList() {
        view.showProgressBar();
        mCashRepo.getCashList(callback);


        //EspressoTestingIdlingResource.increment();

    }

    @Override
    public void loadExpViewList() {

    }

    @Override
    public void dropView() {
       view = null;

    }

    @Override
    public void onError(String errmsg) {

        view.hideProgressBar();
        view.showLoadingError(errmsg);
       // EspressoTestingIdlingResource.decrement();

    }


}
*/
