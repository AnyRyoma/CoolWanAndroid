package com.ryoma.coolwanandroid.presenter.search;

import com.ryoma.coolwanandroid.base.BaseObserver;
import com.ryoma.coolwanandroid.base.presenter.BasePresenter;
import com.ryoma.coolwanandroid.contract.search.SearchArticlesActivityContract;
import com.ryoma.coolwanandroid.model.DataModel;
import com.ryoma.coolwanandroid.model.entity.Articles;
import com.ryoma.coolwanandroid.model.entity.BaseResponse;
import com.ryoma.coolwanandroid.utils.RxUtil;

import javax.inject.Inject;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 搜索文章
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class SearchArticlesActivityPresenter extends BasePresenter<SearchArticlesActivityContract.View>
        implements SearchArticlesActivityContract.Presenter {

    @Inject
    public SearchArticlesActivityPresenter(DataModel model) {
        super(model);
    }

    @Override
    public void loadArticles(int pageNum, String key) {
        addRxSubscribe(
                mModel.getSearchArticles(key, pageNum)
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
    public void loadMoreArticles(int pageNum, String key) {
        addRxSubscribe(
                mModel.getSearchArticles(key, pageNum)
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
