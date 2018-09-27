package com.rdev.horoscopemvvm.ui.base;

import android.arch.lifecycle.ViewModel;

import com.rdev.horoscopemvvm.repository.DataManager;

/**
 * Created by ritadacostaferreira on 20/08/18.
 */

public abstract class BaseViewModel<N> extends ViewModel {
    private N mNavigator;
    private final DataManager mDataManager;
//    private final ObservableBoolean mIsLoading = new ObservableBoolean(false);

    public BaseViewModel(DataManager dataManager) {
        this.mDataManager = dataManager;
    }


    public void onViewCreated() {

    }

    public void onDestroyView() {

    }

    public void setNavigator(N navigator) {
        this.mNavigator = navigator;
    }


    public N getNavigator() {
        return mNavigator;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

}
