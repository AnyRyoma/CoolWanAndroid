package com.example.coolwanandroid.presenter.home;

import android.util.Log;

import com.example.coolwanandroid.base.BaseObserver;
import com.example.coolwanandroid.base.presenter.BasePresenter;
import com.example.coolwanandroid.component.RxBus;
import com.example.coolwanandroid.contract.home.HomeFragmentContract;
import com.example.coolwanandroid.event.AutoRefreshEvent;
import com.example.coolwanandroid.event.NoImgEvent;
import com.example.coolwanandroid.model.DataModel;
import com.example.coolwanandroid.model.entity.Articles;
import com.example.coolwanandroid.model.entity.BannerData;
import com.example.coolwanandroid.model.entity.BaseResponse;
import com.example.coolwanandroid.utils.RxUtil;

import java.util.List;

import javax.inject.Inject;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description HomeFragmentPresenter
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class HomeFragmentPresenter extends BasePresenter<HomeFragmentContract.View> implements HomeFragmentContract.Presenter {
    private static final String TAG = "HomeFragmentPresenter";

    @Inject
    public HomeFragmentPresenter(DataModel model) {
        super(model);
    }

    @Override
    public void subscribeEvent() {
        addRxSubscribe(RxBus.getInstance().toObservable(AutoRefreshEvent.class)
                        .filter(autoRefreshEvent -> autoRefreshEvent.isAutoRefresh())
                        .subscribe(loginEvent -> mView.autoRefresh())
        );

        addRxSubscribe(RxBus.getInstance().toObservable(NoImgEvent.class)
                        .subscribe(noImgEvent -> mView.autoRefresh())
        );
    }

    @Override
    public void loadBannerData() {
        addRxSubscribe(
                mModel.getBannerData()
                        .compose(RxUtil.rxSchedulerHelper())
                        .compose(RxUtil.handleResult())
                        .subscribeWith(new BaseObserver<List<BannerData>>(mView, false, false) {
                            @Override
                            public void onNext(List<BannerData> bannerData) {
                                super.onNext(bannerData);
                                Log.d(TAG, "BannerOnNext: " + bannerData.size());
                                mView.showBannerData(bannerData);
                            }
                        })
        );
    }

    @Override
    public void loadArticles(int pageNum) {
        addRxSubscribe(
                mModel.getArticles(pageNum)
                        .compose(RxUtil.rxSchedulerHelper())
                        .compose(RxUtil.handleResult())
                        .subscribeWith(new BaseObserver<Articles>(mView) {
                            @Override
                            public void onNext(Articles articles) {
                                super.onNext(articles);
                                mView.showArticles(articles.getDatas());
                            }
                        })
        );
    }

    @Override
    public void loadMoreArticles(int pageNum) {
        addRxSubscribe(
                mModel.getArticles(pageNum)
                        .compose(RxUtil.rxSchedulerHelper())
                        .compose(RxUtil.handleResult())
                        .subscribeWith(new BaseObserver<Articles>(mView, false, false) {
                            @Override
                            public void onNext(Articles articles) {
                                super.onNext(articles);
                                mView.showMoreArticles(articles.getDatas());
                            }
                        })
        );
    }

    @Override
    public void collectArticles(int id) {
        addRxSubscribe(
                mModel.collectArticles(id)
                        .compose(RxUtil.rxSchedulerHelper())
                        .subscribeWith(new BaseObserver<BaseResponse>(mView, false, false) {
                            @Override
                            public void onNext(BaseResponse baseResponse) {
                                mView.showCollectSuccess();
                            }
                        })
        );
    }

    @Override
    public void unCollectArticles(int id) {
        addRxSubscribe(
                mModel.unCollectArticles(id)
                        .compose(RxUtil.rxSchedulerHelper())
                        .subscribeWith(new BaseObserver<BaseResponse>(mView, false, false) {
                            @Override
                            public void onNext(BaseResponse baseResponse) {
                                mView.showUnCollectSuccess();
                            }
                        })
        );
    }
}
