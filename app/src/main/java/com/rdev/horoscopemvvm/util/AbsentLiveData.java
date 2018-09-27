package com.rdev.horoscopemvvm.util;

/**
 * Created by ritacf on 08/09/18.
 */

import android.arch.lifecycle.LiveData;

/**
 * A LiveData class that has {@code null} value.
 * Inici<lizar tipo de dados Absent
 */
public class AbsentLiveData extends LiveData {
    private AbsentLiveData() {
        postValue(null);
    }
    public static <T> LiveData<T> create() {
        return new AbsentLiveData();
    }
}