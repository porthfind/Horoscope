package com.rdev.horoscopemvvm.api;

import android.arch.lifecycle.LiveData;

import com.rdev.horoscopemvvm.vo.Channel;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ritacf on 20/08/18.
 */

public interface MainApiHelper {


    @GET("{tipo}.php?")
    LiveData<ApiResponse<Channel>> getHoroscope(@Path("tipo") String type,
                                                @Query("sign")String horoscope,
                                                @Query("id") String id);


}
