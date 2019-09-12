package com.ryoma.coolwanandroid.base.view;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description view接口
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface BaseView {
    /**
     * 设置状态栏颜色
     */
    void setStatusBarColor();

    /**
     * 显示正常布局
     */
    void showNormalView();

    /**
     * 显示错误布局
     */
    void showErrorView();

    /**
     * 重新加载
     */
    void reLoad();

    /**
     * 显示加载布局
     */
    void showLoading();

    /**
     * 显示Toast
     *
     * @param msg 消息内容
     */
    void showToast(String msg);

    /**
     * 改变夜间模式
     *
     * @param isNight 是否为夜晚
     */
    void showNightStyle(boolean isNight);
}
