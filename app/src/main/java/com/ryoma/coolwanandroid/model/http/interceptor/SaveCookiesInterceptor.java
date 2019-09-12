package com.ryoma.coolwanandroid.model.http.interceptor;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 保存cookie
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class SaveCookiesInterceptor implements Interceptor {
    private Context mContext;
    private String TAG = "cookies";

    public SaveCookiesInterceptor(Context context) {
        mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();

            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }
            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(mContext).edit();
            editor.putStringSet(TAG, cookies).apply();

        }
        return originalResponse;
    }
}
