package com.ryoma.coolwanandroid.contract.wx;

import com.ryoma.coolwanandroid.base.presenter.IPresenter;
import com.ryoma.coolwanandroid.base.view.BaseView;
import com.ryoma.coolwanandroid.model.entity.Tab;

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
        /**
         * showWxTab
         *
         * @param tabList tabList
         */
        void showWxTab(List<Tab> tabList);
    }

    interface Presenter extends IPresenter<View> {

        /**
         * loadWxTabData
         */
        void loadWxTabData();
    }
}
