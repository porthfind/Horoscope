package com.rdev.horoscopemvvm.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;

import com.rdev.horoscopemvvm.vo.Channel;
import com.rdev.horoscopemvvm.vo.Item;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by ritacf on 20/08/18.
 */

public class ApiResponse<T> {


    private static final Pattern LINK_PATTERN = Pattern
            .compile("<([^>]*)>[\\s]*;[\\s]*rel=\"([a-zA-Z0-9]+)\"");
    private static final Pattern PAGE_PATTERN = Pattern.compile("\\bpage=(\\d+)");
    private static final String NEXT_LINK = "next";

    public final int code;
    @Nullable
    public final T body;
    @Nullable
    public final String errorMessage;


    public ApiResponse(Throwable error) {
        code = 500;
        body = null;
        errorMessage = error.getMessage();

    }

    public ApiResponse(Response<T> response) {

        code = response.code();
        Timber.d("====Api Response-->"+code);

        if(response.isSuccessful()) {
            Timber.d("response is success");
            body = response.body();

            response.headers();
            errorMessage = null;

        }
        else {
            String message = null;
            if (response.errorBody() != null) {
                try {
                    message = response.errorBody().string();
                } catch (IOException ignored) {
                    Timber.e(ignored, "error while parsing response");
                }
            }
            if (message == null || message.trim().length() == 0) {
                message = response.message();
            }
            errorMessage = message;
            Timber.d("Api-Response.Error:"+errorMessage.toString());
            body = null;
        }

    }

    public boolean isSuccessful() {

        return code >= 200 && code < 300;
    }

}
