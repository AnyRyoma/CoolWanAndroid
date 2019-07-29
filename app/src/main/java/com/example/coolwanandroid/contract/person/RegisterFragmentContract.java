package com.example.coolwanandroid.contract.person;

import android.widget.EditText;

import com.example.coolwanandroid.base.presenter.IPresenter;
import com.example.coolwanandroid.base.view.BaseView;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 注册接口集合
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface RegisterFragmentContract {
    interface View extends BaseView {
        void showSuccess();  //注册成功

        void toLoginFragment();

        String getEditText(EditText editText);
    }

    interface Presenter extends IPresenter<View> {
        void register(String username, String password, String rePassword); //注册
    }
}
