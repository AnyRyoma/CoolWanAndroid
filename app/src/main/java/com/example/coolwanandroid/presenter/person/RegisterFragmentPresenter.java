package com.example.coolwanandroid.presenter.person;

import com.example.coolwanandroid.base.BaseObserver;
import com.example.coolwanandroid.base.presenter.BasePresenter;
import com.example.coolwanandroid.contract.person.RegisterFragmentContract;
import com.example.coolwanandroid.model.DataModel;
import com.example.coolwanandroid.model.entity.BaseResponse;
import com.example.coolwanandroid.utils.RxUtil;

import javax.inject.Inject;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 注册
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class RegisterFragmentPresenter extends BasePresenter<RegisterFragmentContract.View>
        implements RegisterFragmentContract.Presenter {

    @Inject
    public RegisterFragmentPresenter(DataModel model) {
        super(model);
    }

    @Override
    public void register(String username, String password, String rePassword) {
        addRxSubscribe(
                mModel.register(username, password, rePassword)
                        .compose(RxUtil.rxSchedulerHelper())
                        .subscribeWith(new BaseObserver<BaseResponse>(mView, false, false) {
                            @Override
                            public void onNext(BaseResponse response) {
                                if (response.getErrorCode() == 0) {
                                    mView.showSuccess();
                                } else {
                                    mView.showToast(response.getErrorMsg());
                                    mView.showErrorView();
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                super.onError(e);
                                mView.showErrorView();
                            }
                        })
        );
    }
}
