package com.example.coolwanandroid.contract.person;

import android.widget.EditText;

import com.example.coolwanandroid.base.presenter.IPresenter;
import com.example.coolwanandroid.base.view.BaseView;

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
        void showLoginSuccess();//登录成功

        String getEditText(EditText editText);
    }

    interface Presenter extends IPresenter<View> {
        void login(String username, String password);
    }
}
