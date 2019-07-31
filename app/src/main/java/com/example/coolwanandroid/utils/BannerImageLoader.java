package com.example.coolwanandroid.utils;

import android.content.Context;
import android.widget.ImageView;

import com.youth.banner.loader.ImageLoader;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description BannerImageLoader
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class BannerImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        ImageUtil.loadImage(context, imageView, (String) path);
    }
}
