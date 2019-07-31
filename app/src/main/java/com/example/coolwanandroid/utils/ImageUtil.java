package com.example.coolwanandroid.utils;

import android.content.Context;
import android.widget.ImageView;

import com.example.coolwanandroid.R;
import com.example.coolwanandroid.app.App;
import com.example.coolwanandroid.app.GlideApp;


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
