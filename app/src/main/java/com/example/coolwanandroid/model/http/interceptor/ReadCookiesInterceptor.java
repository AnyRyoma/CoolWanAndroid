package com.example.coolwanandroid.model.http.interceptor;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 读取cookie
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class ReadCookiesInterceptor implements Interceptor {
    private Context mContext;
    private String TAG = "cookies";

    public ReadCookiesInterceptor(Context context) {
        mContext = context;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(mContext);
        HashSet<String> preferences = (HashSet) pref.getStringSet(TAG, new HashSet<>());
        for (String cookie : preferences) {
            builder.addHeader("Cookie", cookie);
        }
        return chain.proceed(builder.build());
    }
}