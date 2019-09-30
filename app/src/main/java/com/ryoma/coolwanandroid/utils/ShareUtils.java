package com.ryoma.coolwanandroid.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;

import com.ryoma.coolwanandroid.R;


/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 分享工具
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class ShareUtils {

    /**
     * 分享文本
     *
     * @param context 上下文
     * @param text    文本
     * @param title   标题
     */
    public static void shareText(Context context, String text, String title) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", text);
        if (context.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
            Intent shardIntent = Intent.createChooser(intent, title);
            shardIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(shardIntent);
        } else {
            CommonUtils.toastShow(context.getString(R.string.share_unknown));
        }
    }

    /**
     * 邮件分享
     *
     * @param context 上下文
     * @param address 邮箱地址
     * @param title   标题
     */
    public static void sendEmail(Context context, String address, String title) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + address));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (context.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
            Intent emailIntent = Intent.createChooser(intent, title);
            emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(emailIntent);
        } else {
            CommonUtils.toastShow(context.getString(R.string.share_email_unknown));
        }

    }

    /**
     * 打开浏览器
     *
     * @param context 上下文
     * @param address 路径
     */
    public static void openBrowser(Context context, String address) {
        if (TextUtils.isEmpty(address) || address.startsWith("file://")) {
            CommonUtils.toastShow(context.getString(R.string.article_browser_error));
            return;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse(address));
        if (context.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
            context.startActivity(intent);
        } else {
            CommonUtils.toastShow(context.getString(R.string.open_browser_unknown));
        }
    }

    /**
     * 复制字符串
     *
     * @param context 上下文
     * @param text    被复制的文本
     */
    public static void copyString(Context context, String text) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        ClipboardManager mClipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        assert mClipboardManager != null;
        mClipboardManager.setPrimaryClip(ClipData.newPlainText(null, text));
    }
}
