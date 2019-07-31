package com.example.coolwanandroid.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.example.coolwanandroid.app.Constant;
import com.example.coolwanandroid.service.UpdateApkService;

import java.io.File;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 更新下载版本工具
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class DownloadUtil {

    /**
     * 下载apk
     */
    public static void downloadApk(Context context, String downloadUrl) {
        if (canDownloadState(context)) {
            //使用downloadManager下载
            LogUtil.d(LogUtil.TAG_COMMON, "DownloadManager可用");
            Intent intent = new Intent(context, UpdateApkService.class);
            intent.putExtra(Constant.KEY_APK_URL, downloadUrl);
            context.startService(intent);
        } else {
            //使用浏览器打开
            LogUtil.d(LogUtil.TAG_COMMON, "DownloadManager 不可用");
            File file = new File(Constant.PATH_APK_BROWSE);
            if (file.exists())
                file.delete();
            ShareUtils.openBrowser(context, downloadUrl);
        }
    }

    /**
     * 是否可以使用DownloadManager,如果不能则使用系统浏览器
     */
    private static boolean canDownloadState(Context context) {
        try {
            int state = context.getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");
            if (state == PackageManager.COMPONENT_ENABLED_STATE_DISABLED
                    || state == PackageManager.COMPONENT_ENABLED_STATE_DISABLED_USER
                    || state == PackageManager.COMPONENT_ENABLED_STATE_DISABLED_UNTIL_USED) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * 获取版本号
     *
     * @param context context
     */
    public static String getVersionName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String version = "";
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES);
            version = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }
}
