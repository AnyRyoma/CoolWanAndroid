package com.example.coolwanandroid.base.presenter;

import com.example.coolwanandroid.base.view.BaseView;

import io.reactivex.disposables.Disposable;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface IPresenter<T extends BaseView> {
    void attachView(T view);  //注入View

    boolean isAttachView();  //判断是否注入View

    void detachView();      //解除View

    //管理Rx的订阅事件
    void addRxSubscribe(Disposable disposable);

    //订阅事件
    void subscribeEvent();

    boolean getNightStyleState();//得到夜间模式的状态

    boolean getNoImgStyleState();//得到无图模式的状态

    boolean getAutoCacheState();//得到自动缓存模式的状态
}
