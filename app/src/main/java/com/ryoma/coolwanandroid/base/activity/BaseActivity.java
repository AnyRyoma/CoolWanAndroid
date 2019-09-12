package com.ryoma.coolwanandroid.base.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import com.ryoma.coolwanandroid.R;
import com.ryoma.coolwanandroid.base.view.BaseView;
import com.ryoma.coolwanandroid.app.App;
import com.ryoma.coolwanandroid.component.ActivityCollector;
import com.ryoma.coolwanandroid.di.component.AppComponent;
import com.ryoma.coolwanandroid.utils.CommonUtils;
import com.ryoma.coolwanandroid.utils.StatusBarUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author eco-ryoma
 * @date 2019/01/29
 * @description Activity的基类
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private Unbinder mBinder;

    /**
     * 获取当前Activity布局的id
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 注入
     */
    protected abstract void inject();

    /**
     * 初始化views
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mBinder = ButterKnife.bind(this);
        ActivityCollector.getInstance().addActivity(this);
        setStatusBarColor();
        inject();
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.getInstance().removeActivity(this);
        if (mBinder != null && mBinder != Unbinder.EMPTY) {
            mBinder.unbind();
            mBinder = null;
        }
    }


    protected AppComponent getAppComponent() {
        return ((App) getApplication()).getAppComponent();
    }

    @Override
    public void setStatusBarColor() {
        StatusBarUtil.setStatusColor(getWindow(), getResources().getColor(R.color.colorPrimaryDark), 1);
    }

    @Override
    public void showNormalView() {

    }

    @Override
    public void showErrorView() {

    }

    @Override
    public void reLoad() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showToast(String msg) {
        CommonUtils.toastShow(msg);
    }

    @Override
    public void showNightStyle(boolean isNight) {
        AppCompatDelegate.setDefaultNightMode(isNight ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
    }

}
