package com.ryoma.coolwanandroid.presenter.person;

import com.ryoma.coolwanandroid.base.BaseObserver;
import com.ryoma.coolwanandroid.base.presenter.BasePresenter;
import com.ryoma.coolwanandroid.component.RxBus;
import com.ryoma.coolwanandroid.contract.person.CollectionActivityContract;
import com.ryoma.coolwanandroid.event.CollectionEvent;
import com.ryoma.coolwanandroid.model.DataModel;
import com.ryoma.coolwanandroid.model.entity.BaseResponse;
import com.ryoma.coolwanandroid.model.entity.Collections;
import com.ryoma.coolwanandroid.utils.RxUtil;

import javax.inject.Inject;


/**
 * @author eco-ryoma
 * @date 2019/8/1
 * @description 收藏页面presenter
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class CollectionActivityPresenter extends BasePresenter<CollectionActivityContract.View>
        implements CollectionActivityContract.Presenter {

    @Inject
    public CollectionActivityPresenter(DataModel model) {
        super(model);
    }

    @Override
    public void subscribeEvent() {
        //cookie过期后重新加载我的收藏
        addRxSubscribe(RxBus.getInstance().toObservable(CollectionEvent.class)
                .subscribe(collectionEvent -> mView.reLoad())
        );
    }

    @Override
    public void loadCollections(int pageNum) {
        addRxSubscribe(mModel.getCollectionsData(pageNum)
                .compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.handleResult())
                .subscribeWith(new BaseObserver<Collections>(mView) {
                    @Override
                    public void onNext(Collections collections) {
                        super.onNext(collections);
                        mView.showCollections(collections.getDatas());
                    }
                })
        );
    }

    @Override
    public void loadMoreCollections(int pageNum) {
        addRxSubscribe(mModel.getCollectionsData(pageNum)
                .compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.handleResult())
                .subscribeWith(new BaseObserver<Collections>(mView, false, false) {
                    @Override
                    public void onNext(Collections collections) {
                        mView.showMoreCollections(collections.getDatas());
                    }
                })
        );
    }

    @Override
    public void unCollectArticles(int id, int originId) {
        addRxSubscribe(mModel.unCollection(id, originId)
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
