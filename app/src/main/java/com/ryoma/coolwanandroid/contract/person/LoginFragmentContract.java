package com.ryoma.coolwanandroid.contract.person;

import android.widget.EditText;

import com.ryoma.coolwanandroid.base.presenter.IPresenter;
import com.ryoma.coolwanandroid.base.view.BaseView;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 登录
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface LoginFragmentContract {

    interface View extends BaseView {
        /**
         * 登陆成功
         */
        void showLoginSuccess();

        /**
         * getEditText
         *
         * @param editText editText
         * @return 文本
         */
        String getEditText(EditText editText);
    }

    interface Presenter extends IPresenter<View> {

        /**
         * login
         *
         * @param username username
         * @param password password
         */
        void login(String username, String password);
    }
}
