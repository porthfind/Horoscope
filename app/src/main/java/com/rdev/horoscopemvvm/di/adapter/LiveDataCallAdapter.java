package com.rdev.horoscopemvvm.di.adapter;

import android.arch.lifecycle.LiveData;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;
import com.rdev.horoscopemvvm.api.ApiResponse;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by ritacf on 20/08/18.
 */

public class LiveDataCallAdapter <R> implements CallAdapter<R, LiveData<ApiResponse<R>>> {
    private final Type responseType;
    public LiveDataCallAdapter(Type responseType) {
        this.responseType = responseType;
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @Override
    public LiveData<ApiResponse<R>> adapt(final Call<R> call) {
        return new LiveData<ApiResponse<R>>() {
            AtomicBoolean started = new AtomicBoolean(false);
            @Override
            protected void onActive() {
                super.onActive();
                if (started.compareAndSet(false, true)) {
                    call.enqueue(new Callback<R>() {
                        @Override
                        public void onResponse(Call<R> call, Response<R> response) {
                            Timber.d("Estou no no LiveData Adapters!! ----- ");
                            postValue(new ApiResponse<R>(response));

                        }

                        @Override
                        public void onFailure(Call<R> call, Throwable throwable) {
                            postValue(new ApiResponse<R>(throwable));
                            Timber.d("===== Error =====" + throwable.getMessage());

                        }
                    });
                }
            }
        };
    }
}
