package com.example.coolwanandroid.contract.person;

import com.example.coolwanandroid.base.presenter.IPresenter;
import com.example.coolwanandroid.base.view.BaseView;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 我的模块
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface PersonFragmentContract {
    interface View extends BaseView {
        void showLogin();

        void showLogout();
    }

    interface Presenter extends IPresenter<View> {
        void logout();
    }
}
