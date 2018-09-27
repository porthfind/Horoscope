package com.rdev.horoscopemvvm.util;

import android.arch.persistence.room.TypeConverter;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.Date;

import timber.log.Timber;

/**
 * Created by ritacf on 23/07/18.
 */

public class AppUtils {

    private AppUtils() {
    }

    public static boolean existsInternet(Context context){

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if(activeNetwork != null && activeNetwork.isConnectedOrConnecting())
            return true;

        else
            return false;
    }



}

