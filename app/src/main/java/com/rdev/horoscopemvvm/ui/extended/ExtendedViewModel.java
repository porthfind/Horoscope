package com.rdev.horoscopemvvm.ui.extended;

import android.arch.lifecycle.LiveData;

import com.rdev.horoscopemvvm.repository.DataManager;
import com.rdev.horoscopemvvm.ui.base.BaseViewModel;
import com.rdev.horoscopemvvm.vo.Horoscopo;

import timber.log.Timber;

/**
 * Created by ritacf on 20/08/18.
 */

public class ExtendedViewModel extends BaseViewModel<ExtendedNavigator> {

    private final DataManager mDataManager;

    public ExtendedViewModel(DataManager mDataManager) {
        super(mDataManager);
        this.mDataManager = mDataManager;
    }



    public LiveData<Horoscopo> getHoroscope(String data, String horoscope, String type){
        return mDataManager.getHoroscopeAPI(data, horoscope, type);
    }

}
