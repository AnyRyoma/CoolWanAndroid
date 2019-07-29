package com.example.coolwanandroid.base.view;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description view接口
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface BaseView {
    void setStatusBarColor();  //设置状态栏颜色

    void showNormalView(); //显示正常布局

    void showErrorView();  //显示错误布局

    void reLoad(); //重新加载

    void showLoading();  //显示加载布局

    void showToast(String msg);  //显示Toast

    void showNightStyle(boolean isNight); //改变夜间模式
}
