package com.example.coolwanandroid.presenter.person;

import com.example.coolwanandroid.app.User;
import com.example.coolwanandroid.base.BaseObserver;
import com.example.coolwanandroid.base.presenter.BasePresenter;
import com.example.coolwanandroid.component.RxBus;
import com.example.coolwanandroid.contract.person.PersonFragmentContract;
import com.example.coolwanandroid.event.AutoRefreshEvent;
import com.example.coolwanandroid.event.LoginEvent;
import com.example.coolwanandroid.model.DataModel;
import com.example.coolwanandroid.model.entity.BaseResponse;
import com.example.coolwanandroid.utils.RxUtil;

import javax.inject.Inject;



public class PersonFragmentPresenter extends BasePresenter<PersonFragmentContract.View>
        implements PersonFragmentContract.Presenter {

    @Inject
    public PersonFragmentPresenter(DataModel model) {
        super(model);
    }
    @Override
    public void subscribeEvent() {
        addRxSubscribe(
                RxBus.getInstance().toObservable(LoginEvent.class)
                        .filter(loginEvent -> loginEvent.isLogin())
                        .subscribe(loginEvent -> mView.showLogin())
        );
    }

    @Override
    public void logout() {
       addRxSubscribe(
               mModel.logout()
               .compose(RxUtil.rxSchedulerHelper())
               .subscribeWith(new BaseObserver<BaseResponse>(mView,false,false){
                   @Override
                   public void onNext(BaseResponse baseResponse){
                       User.getInstance().reset();
                       RxBus.getInstance().post(new AutoRefreshEvent(true));
                       mView.showLogout();
                   }
               })
       );
    }
}
