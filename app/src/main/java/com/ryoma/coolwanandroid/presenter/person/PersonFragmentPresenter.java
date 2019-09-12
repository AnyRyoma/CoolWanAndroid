package com.ryoma.coolwanandroid.presenter.person;

import com.ryoma.coolwanandroid.app.User;
import com.ryoma.coolwanandroid.base.BaseObserver;
import com.ryoma.coolwanandroid.base.presenter.BasePresenter;
import com.ryoma.coolwanandroid.component.RxBus;
import com.ryoma.coolwanandroid.contract.person.PersonFragmentContract;
import com.ryoma.coolwanandroid.event.AutoRefreshEvent;
import com.ryoma.coolwanandroid.event.LoginEvent;
import com.ryoma.coolwanandroid.model.DataModel;
import com.ryoma.coolwanandroid.model.entity.BaseResponse;
import com.ryoma.coolwanandroid.utils.RxUtil;

import javax.inject.Inject;

/**
 * @author chenyijun
 * @date 2019-08-20
 * @description PersonFragmentPresenter
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class PersonFragmentPresenter extends BasePresenter<PersonFragmentContract.View>
        implements PersonFragmentContract.Presenter {

    @Inject
    public PersonFragmentPresenter(DataModel model) {
        super(model);
    }

    @Override
    public void subscribeEvent() {
        addRxSubscribe(RxBus.getInstance().toObservable(LoginEvent.class)
                .filter(loginEvent -> loginEvent.isLogin())
                .subscribe(loginEvent -> mView.showLogin())
        );
    }

    @Override
    public void logout() {
        addRxSubscribe(mModel.logout()
                .compose(RxUtil.rxSchedulerHelper())
                .subscribeWith(new BaseObserver<BaseResponse>(mView, false, false) {
                    @Override
                    public void onNext(BaseResponse baseResponse) {
                        User.getInstance().reset();
                        RxBus.getInstance().post(new AutoRefreshEvent(true));
                        mView.showLogout();
                    }
                })
        );
    }
}
