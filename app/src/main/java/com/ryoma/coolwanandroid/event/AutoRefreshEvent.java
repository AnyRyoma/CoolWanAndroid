package com.ryoma.coolwanandroid.event;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 收藏
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class AutoRefreshEvent {
    private boolean isAutoRefresh;

    public AutoRefreshEvent(boolean isAutoRefresh) {
        this.isAutoRefresh = isAutoRefresh;
    }

    public boolean isAutoRefresh() {
        return isAutoRefresh;
    }
}
