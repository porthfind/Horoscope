package com.rdev.horoscopemvvm.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;

import com.rdev.horoscopemvvm.api.ApiResponse;
import com.rdev.horoscopemvvm.api.MainApiHelper;
import com.rdev.horoscopemvvm.util.AbsentLiveData;
import com.rdev.horoscopemvvm.vo.Channel;
import com.rdev.horoscopemvvm.vo.Horoscopo;

import javax.inject.Inject;

import timber.log.Timber;

import static com.rdev.horoscopemvvm.util.AppConstants.id;

/**
 * Created by ritadacostaferreira on 20/08/18.
 */

public class AppDataManager implements DataManager {

    private MainApiHelper mMainApiHelper;


    @Inject
    public AppDataManager(MainApiHelper mainApiHelper) {
        this.mMainApiHelper = mainApiHelper;
    }

    @Override
    public LiveData<Horoscopo> getHoroscopeAPI(String date, String horoscope, String type) {

        LiveData<Horoscopo> channel = AbsentLiveData.create();
        final MutableLiveData<Horoscopo> updatedResult = new MediatorLiveData<>();
Timber.d("Antes de fazer o getHoroscope - repositorio");

        //This method waits until it has the data to process
        channel = Transformations.switchMap(getHoroscope(date, horoscope, type), apiResponse -> {




            if (apiResponse.isSuccessful()) {

                    String rss = apiResponse.body.toString();
                    Horoscopo hor = new Horoscopo();

                    hor.setType(type);
                    hor.setName(horoscope);
                    hor.setDescription(rss);

                    updatedResult.postValue(hor);
            } else {
                Timber.d("=== error");
                Horoscopo hor = new Horoscopo();
                hor.setType(type);
                hor.setName(horoscope);
                hor.setDescription("");
                updatedResult.postValue(hor);

            }
            return updatedResult;
        });
        return channel;
    }


    @Override
    public LiveData<ApiResponse<Channel>> getHoroscope(String data, String horos, String type) {


        if(type.compareToIgnoreCase("weekly") == 0)
            type = type + "-" +"horoscope";
        else if(type.compareToIgnoreCase("monthly")==0){
            type = type + "-" +"horoscope";
        }
        else
            type = type + "horoscope-feed";

        return mMainApiHelper.getHoroscope(type, horos, id);
    }



}
