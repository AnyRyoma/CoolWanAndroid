package com.ryoma.coolwanandroid.base.presenter;

import com.ryoma.coolwanandroid.base.view.BaseView;

import io.reactivex.disposables.Disposable;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface IPresenter<T extends BaseView> {
    /**
     * 注入View
     *
     * @param view 控件
     */
    void attachView(T view);

    /**
     * 判断是否注入View
     *
     * @return
     */
    boolean isAttachView();

    /**
     * 解除View
     */
    void detachView();

    /**
     * 管理Rx的订阅事件
     *
     * @param disposable 事件
     */
    void addRxSubscribe(Disposable disposable);

    /**
     * 订阅事件
     */
    void subscribeEvent();

    /**
     * 得到夜间模式的状态
     *
     * @return style state
     */
    boolean getNightStyleState();

    boolean getNoImgStyleState();//得到无图模式的状态

    boolean getAutoCacheState();//得到自动缓存模式的状态
}
