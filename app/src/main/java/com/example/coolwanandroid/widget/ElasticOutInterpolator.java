package com.example.coolwanandroid.widget;

import android.view.animation.Interpolator;

/**
 * @author eco-ryoma
 * @date 2019/03/08
 * @description 自定义弹簧插值器
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class ElasticOutInterpolator implements Interpolator {

    @Override
    public float getInterpolation(float input) {
        if (input == 0) {
            return 0;
        }
        if (input >= 1) {
            return 1;
        }
        float p = .3f;
        float s = p / 4;
        return ((float) Math.pow(2, -10 * input) * (float) Math.sin((input - s) * (2 * (float) Math.PI) / p) + 1);
    }

}

