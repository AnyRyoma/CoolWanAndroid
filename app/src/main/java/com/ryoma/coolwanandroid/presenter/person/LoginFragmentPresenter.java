package com.ryoma.coolwanandroid.presenter.person;

import com.ryoma.coolwanandroid.app.User;
import com.ryoma.coolwanandroid.base.BaseObserver;
import com.ryoma.coolwanandroid.base.presenter.BasePresenter;
import com.ryoma.coolwanandroid.component.RxBus;
import com.ryoma.coolwanandroid.contract.person.LoginFragmentContract;
import com.ryoma.coolwanandroid.event.AutoRefreshEvent;
import com.ryoma.coolwanandroid.event.LoginEvent;
import com.ryoma.coolwanandroid.model.DataModel;
import com.ryoma.coolwanandroid.model.entity.BaseResponse;
import com.ryoma.coolwanandroid.utils.RxUtil;

import javax.inject.Inject;

/**
 * @author eco-ryoma
 * @date 2019/8/1
 * @description 登录页presenter
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class LoginFragmentPresenter extends BasePresenter<LoginFragmentContract.View>
        implements LoginFragmentContract.Presenter {

    @Inject
    public LoginFragmentPresenter(DataModel model) {
        super(model);
    }

    @Override
    public void login(String username, String password) {
        addRxSubscribe(mModel.login(username, password)
                .compose(RxUtil.rxSchedulerHelper())
                .subscribeWith(new BaseObserver<BaseResponse>(mView, false, false) {
                    @Override
                    public void onNext(BaseResponse baseResponse) {
                        if (baseResponse.getErrorCode() == 0) {
                            User user = User.getInstance();
                            user.setPassword(password);
                            user.setUsername(username);
                            user.setLoginStatus(true);
                            user.save();
                            RxBus.getInstance().post(new LoginEvent(true));
                            RxBus.getInstance().post(new AutoRefreshEvent(true));
                            mView.showLoginSuccess();
                        } else {
                            mView.showToast(baseResponse.getErrorMsg());
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
