package com.rdev.horoscopemvvm.repository;

import android.arch.lifecycle.LiveData;

import com.rdev.horoscopemvvm.api.ApiResponse;
import com.rdev.horoscopemvvm.vo.Channel;
import com.rdev.horoscopemvvm.vo.Horoscopo;

/**
 * Created by ritadacostaferreira on 20/08/18.
 */

public interface DataManager {

    //boolean isTodayRun(String data, String horoscope, String type);
    //void setTodayRun(String data, String horos, String type);
    LiveData<Horoscopo> getHoroscopeAPI(String data, String horoscope, String type);

    LiveData<ApiResponse<Channel>>getHoroscope(String data, String horos, String type);
    //void saveHoroscope(Horoscope horoscope);
/*
    LiveData<Boolean> LiveDataReturn();*/


}
