package com.ryoma.coolwanandroid.base;

import android.net.ParseException;

import com.ryoma.coolwanandroid.R;
import com.ryoma.coolwanandroid.base.view.BaseView;
import com.ryoma.coolwanandroid.app.App;
import com.ryoma.coolwanandroid.app.User;
import com.ryoma.coolwanandroid.component.RxBus;
import com.ryoma.coolwanandroid.event.AutoRefreshEvent;
import com.ryoma.coolwanandroid.event.CollectionEvent;
import com.ryoma.coolwanandroid.model.entity.Login;
import com.ryoma.coolwanandroid.model.http.exception.ApiException;
import com.ryoma.coolwanandroid.utils.LogUtil;
import com.ryoma.coolwanandroid.utils.RxUtil;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;
import retrofit2.HttpException;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 对RxJava的下游即数据进行处理
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public abstract class BaseObserver<T> extends ResourceObserver<T> {
    private BaseView mView;
    private boolean isShowErrorView = true;
    private boolean isShowLoading = true;
    private Disposable mDisposable;

    private BaseObserver() {
    }

    protected BaseObserver(BaseView view) {
        this(view, true, true);
    }

    protected BaseObserver(BaseView view, boolean isShowErrorView) {
        this(view, isShowErrorView, true);
    }

    protected BaseObserver(BaseView view, boolean isShowErrorView, boolean isShowLoading) {
        mView = view;
        this.isShowErrorView = isShowErrorView;
        this.isShowLoading = isShowLoading;
    }


    @Override
    protected void onStart() {
        if (isShowLoading)
            mView.showLoading();
    }

    @Override
    public void onNext(T t) {
        mView.showNormalView();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof UnknownHostException) {
            LogUtil.e(LogUtil.TAG_ERROR, "networkError：" + e.getMessage());
            networkError();
        } else if (e instanceof InterruptedException) {
            LogUtil.e(LogUtil.TAG_ERROR, "timeout：" + e.getMessage());
            timeoutError();
        } else if (e instanceof HttpException) {
            LogUtil.e(LogUtil.TAG_ERROR, "http错误：" + e.getMessage());
            httpError();
        } else if (e instanceof JsonParseException || e instanceof JSONException || e instanceof ParseException) {
            LogUtil.e(LogUtil.TAG_ERROR, "解析错误：" + e.getMessage());
            parseError();
        } else if (e instanceof ApiException) {
            LogUtil.e(LogUtil.TAG_ERROR, "unknown：" + ((ApiException) e).getErrorCode());
            ApiException apiException = (ApiException) e;
            //cookie过期处理
            if (apiException.getErrorCode() == -1001) {
                //重新发起登录
                App.getAppComponent().getDataModel()
                        .login(User.getInstance().getUsername(), User.getInstance().getPassword())
                        .compose(RxUtil.rxSchedulerHelper())
                        .compose(RxUtil.handleResult())
                        .subscribe(new Observer<Login>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                mDisposable = d;
                            }

                            @Override
                            public void onNext(Login value) {
                                LogUtil.d(LogUtil.TAG_ERROR, "重新登录成功");
                                //通知
                                RxBus.getInstance().post(new CollectionEvent()); //通知我的收藏列表
                                RxBus.getInstance().post(new AutoRefreshEvent(true));//通知主页面
                            }

                            @Override
                            public void onError(Throwable e) {
                                LogUtil.d(LogUtil.TAG_ERROR, "重新登录失败");
                                mView.showToast(apiException.getErrorMessage());
                            }

                            @Override
                            public void onComplete() {
                                if (mDisposable != null)
                                    mDisposable.dispose();
                            }
                        });
            }
        } else {
            LogUtil.e(LogUtil.TAG_ERROR, "unknown：" + e.toString());
            unknown();
        }
    }

    @Override
    public void onComplete() {
    }

    /**
     * 未知错误
     */
    protected void unknown() {
        mView.showToast(App.getContext().getString(R.string.error_unknown));
        if (isShowErrorView)
            mView.showErrorView();
    }

    /**
     * 解析错误
     */
    protected void parseError() {
        mView.showToast(App.getContext().getString(R.string.error_parse));
        if (isShowErrorView)
            mView.showErrorView();
    }

    /**
     * http错误
     */
    protected void httpError() {
        mView.showToast(App.getContext().getString(R.string.error_http));
        if (isShowErrorView) {
            LogUtil.d(LogUtil.TAG_COMMON, "errorView");
            mView.showErrorView();
        }
    }

    /**
     * 网络超时异常
     */
    protected void timeoutError() {
        mView.showToast(App.getContext().getString(R.string.error_timeout));
        if (isShowErrorView)
            mView.showErrorView();
    }

    /**
     * 网络不可用异常
     */
    protected void networkError() {
        mView.showToast(App.getContext().getString(R.string.error_network));
        if (isShowErrorView)
            mView.showErrorView();
    }


}
