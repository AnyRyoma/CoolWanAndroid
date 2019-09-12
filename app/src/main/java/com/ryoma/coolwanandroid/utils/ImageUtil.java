package com.ryoma.coolwanandroid.utils;

import android.content.Context;
import android.widget.ImageView;

import com.ryoma.coolwanandroid.R;
import com.ryoma.coolwanandroid.app.App;
import com.ryoma.coolwanandroid.app.GlideApp;


/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 图片工具类
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class ImageUtil {
    public static void loadImage(Context context, ImageView imageView, String path) {
        if (App.getAppComponent().getDataModel().getNoImgStyleState()) {
            path = null;
        }

        GlideApp.with(context)
                .load(path)
                .placeholder(R.drawable.test_jay)
                .error(R.drawable.test_jay)
                .into(imageView);
    }
}
