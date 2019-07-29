package com.example.coolwanandroid.contract.wx;

import com.example.coolwanandroid.base.presenter.IPresenter;
import com.example.coolwanandroid.base.view.BaseView;
import com.example.coolwanandroid.model.entity.Tab;

import java.util.List;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 微信公众号Tab的Mvp接口集合
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface WxFragmentContract {
    interface View extends BaseView {
        void showWxTab(List<Tab> tabList);
    }

    interface Presenter extends IPresenter<View> {
        void loadWxTabData();
    }
}
