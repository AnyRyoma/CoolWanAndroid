package com.example.coolwanandroid.presenter.person;

import com.example.coolwanandroid.app.User;
import com.example.coolwanandroid.base.BaseObserver;
import com.example.coolwanandroid.base.presenter.BasePresenter;
import com.example.coolwanandroid.component.RxBus;
import com.example.coolwanandroid.contract.person.LoginFragmentContract;
import com.example.coolwanandroid.event.AutoRefreshEvent;
import com.example.coolwanandroid.event.LoginEvent;
import com.example.coolwanandroid.model.DataModel;
import com.example.coolwanandroid.model.entity.BaseResponse;
import com.example.coolwanandroid.utils.RxUtil;

import javax.inject.Inject;


public class LoginFragmentPresenter extends BasePresenter<LoginFragmentContract.View>
        implements LoginFragmentContract.Presenter {

    @Inject
    public LoginFragmentPresenter(DataModel model) {
        super(model);
    }

    @Override
    public void login(String username, String password) {
        addRxSubscribe(
                mModel.login(username, password)
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
