package com.ryoma.coolwanandroid.utils;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 日志打印工具
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class LogUtil {
    private static final boolean isDebug = true;
    public static final String TAG_ERROR = "error";
    public static final String TAG_COMMON = "jsyjst";
    public static final String TAG_HTTP = "http";

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (isDebug)
            android.util.Log.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            android.util.Log.d(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            android.util.Log.e(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            android.util.Log.v(tag, msg);
    }

    private LogUtil() throws Exception {
        throw new AssertionError();
    }
}
