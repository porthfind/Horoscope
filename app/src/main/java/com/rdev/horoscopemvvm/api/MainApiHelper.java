package com.rdev.horoscopemvvm.api;

import android.arch.lifecycle.LiveData;

import com.rdev.horoscopemvvm.vo.Channel;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ritadacostaferreira on 20/08/18.
 */

public interface MainApiHelper {

    //https://www.findyourfate.com/rss/weekly-horoscope.php?sign=Gemini&id=45
    //https://www.findyourfate.com/rss/dailyhoroscope-feed.php?sign=Gemini&id=45
    //https://www.findyourfate.com/rss/monthly-horoscope.php?sign=Gemini&id=45


    @GET("{tipo}.php?")
    LiveData<ApiResponse<Channel>> getHoroscope(@Path("tipo") String type,
                                                @Query("sign")String horoscope,
                                                @Query("id") String id);


}
