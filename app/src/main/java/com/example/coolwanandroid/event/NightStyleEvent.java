package com.example.coolwanandroid.event;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 夜间模式
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class NightStyleEvent {
    private boolean isNight;

    public NightStyleEvent(boolean isNight) {
        this.isNight = isNight;
    }

    public boolean isNight() {
        return isNight;
    }

    public void setNight(boolean night) {
        isNight = night;
    }
}
