package com.ryoma.coolwanandroid.presenter.system;

import com.ryoma.coolwanandroid.base.BaseObserver;
import com.ryoma.coolwanandroid.base.presenter.BasePresenter;
import com.ryoma.coolwanandroid.contract.system.SystemArticlesFragmentContract;
import com.ryoma.coolwanandroid.model.DataModel;
import com.ryoma.coolwanandroid.model.entity.Articles;
import com.ryoma.coolwanandroid.model.entity.BaseResponse;
import com.ryoma.coolwanandroid.utils.RxUtil;

import javax.inject.Inject;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class SystemArticlesFragmentPresenter extends BasePresenter<SystemArticlesFragmentContract.View>
        implements SystemArticlesFragmentContract.Presenter {


    @Inject
    public SystemArticlesFragmentPresenter(DataModel model) {
        super(model);
    }

    @Override
    public void loadSystemArticlesData(int pageNum, int id) {
        addRxSubscribe(mModel.getSecondSystemArticles(pageNum, id)
                .compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.handleResult())
                .subscribeWith(new BaseObserver<Articles>(mView) {
                    @Override
                    public void onNext(Articles articles) {
                        super.onNext(articles);
                        mView.showSystemArticles(articles.getDatas());
                    }
                })
        );
    }

    @Override
    public void loadMoreSystemArticlesData(int pageNum, int id) {
        addRxSubscribe(mModel.getSecondSystemArticles(pageNum, id)
                .compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.handleResult())
                .subscribeWith(new BaseObserver<Articles>(mView, false, false) {
                    @Override
                    public void onNext(Articles articles) {
                        super.onNext(articles);
                        mView.showMoreSystemArticles(articles.getDatas());
                    }
                })
        );
    }

    @Override
    public void collectArticles(int id) {
        addRxSubscribe(mModel.collectArticles(id)
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
        addRxSubscribe(mModel.unCollectArticles(id)
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
