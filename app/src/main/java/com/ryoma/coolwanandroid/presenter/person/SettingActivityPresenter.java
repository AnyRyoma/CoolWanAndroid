package com.ryoma.coolwanandroid.presenter.person;

import com.ryoma.coolwanandroid.base.presenter.BasePresenter;
import com.ryoma.coolwanandroid.component.RxBus;
import com.ryoma.coolwanandroid.contract.person.SettingActivityContract;
import com.ryoma.coolwanandroid.event.NightStyleEvent;
import com.ryoma.coolwanandroid.event.NoImgEvent;
import com.ryoma.coolwanandroid.model.DataModel;

import javax.inject.Inject;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 设置
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class SettingActivityPresenter extends BasePresenter<SettingActivityContract.View>
        implements SettingActivityContract.Presenter {

    @Inject
    public SettingActivityPresenter(DataModel model) {
        super(model);
    }

    @Override
    public void subscribeEvent() {
        addRxSubscribe(
                RxBus.getInstance().toObservable(NightStyleEvent.class)
                        .subscribe(nightStyleEvent -> {
                            mView.showNightStyle(nightStyleEvent.isNight());
                            mView.showChangeNightStyle();
                        })
        );
    }

    @Override
    public void setNightStyleState(boolean isNight) {
        mModel.setNightStyleState(isNight);
        RxBus.getInstance().post(new NightStyleEvent(isNight));
    }

    @Override
    public void setNoImgStyleState(boolean isNoImg) {
        mModel.setNoImgState(isNoImg);
        RxBus.getInstance().post(new NoImgEvent());
    }

    @Override
    public void setAutoCacheStyleState(boolean isAutoCache) {
        mModel.setAutoCacheState(isAutoCache);
    }
}
