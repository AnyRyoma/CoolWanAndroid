package com.ryoma.coolwanandroid.contract.person;

import com.ryoma.coolwanandroid.base.presenter.IPresenter;
import com.ryoma.coolwanandroid.base.view.BaseView;

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
