package com.ryoma.coolwanandroid.presenter.system;

import com.ryoma.coolwanandroid.base.BaseObserver;
import com.ryoma.coolwanandroid.base.presenter.BasePresenter;
import com.ryoma.coolwanandroid.contract.system.SystemFragmentContract;
import com.ryoma.coolwanandroid.model.DataModel;
import com.ryoma.coolwanandroid.model.entity.FirstSystem;
import com.ryoma.coolwanandroid.utils.RxUtil;

import java.util.List;

import javax.inject.Inject;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class SystemFragmentPresenter extends BasePresenter<SystemFragmentContract.View>
        implements SystemFragmentContract.Presenter {

    @Inject
    public SystemFragmentPresenter(DataModel model) {
        super(model);
    }

    @Override
    public void loadSystemData(boolean isShowLoadingView) {
        addRxSubscribe(mModel.getFirstSystemData()
                .compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.handleResult())
                .subscribeWith(new BaseObserver<List<FirstSystem>>(mView, true, isShowLoadingView) {
                    @Override
                    public void onNext(List<FirstSystem> firstSystemList) {
                        super.onNext(firstSystemList);
                        mView.showSystemData(firstSystemList);
                    }
                }));

    }
}
