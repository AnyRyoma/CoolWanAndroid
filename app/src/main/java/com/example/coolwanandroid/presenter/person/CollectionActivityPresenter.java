package com.example.coolwanandroid.presenter.person;

import com.example.coolwanandroid.base.BaseObserver;
import com.example.coolwanandroid.base.presenter.BasePresenter;
import com.example.coolwanandroid.component.RxBus;
import com.example.coolwanandroid.contract.person.CollectionActivityContract;
import com.example.coolwanandroid.event.CollectionEvent;
import com.example.coolwanandroid.model.DataModel;
import com.example.coolwanandroid.model.entity.BaseResponse;
import com.example.coolwanandroid.model.entity.Collections;
import com.example.coolwanandroid.utils.RxUtil;

import javax.inject.Inject;




public class CollectionActivityPresenter extends BasePresenter<CollectionActivityContract.View>
        implements CollectionActivityContract.Presenter {

    @Inject
    public CollectionActivityPresenter(DataModel model) {
        super(model);
    }

    @Override
    public void subscribeEvent() {
        //cookie过期后重新加载我的收藏
        addRxSubscribe(
                RxBus.getInstance().toObservable(CollectionEvent.class)
                        .subscribe(collectionEvent -> mView.reLoad())
        );
    }

    @Override
    public void loadCollections(int pageNum) {
        addRxSubscribe(
                mModel.getCollectionsData(pageNum)
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
        addRxSubscribe(
                mModel.getCollectionsData(pageNum)
                        .compose(RxUtil.rxSchedulerHelper())
                        .compose(RxUtil.handleResult())
                        .subscribeWith(new BaseObserver<Collections>(mView,false,false) {
                            @Override
                            public void onNext(Collections collections) {
                                mView.showMoreCollections(collections.getDatas());
                            }
                        })
        );
    }

    @Override
    public void unCollectArticles(int id,int originId) {
        addRxSubscribe(
                mModel.unCollection(id,originId)
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
