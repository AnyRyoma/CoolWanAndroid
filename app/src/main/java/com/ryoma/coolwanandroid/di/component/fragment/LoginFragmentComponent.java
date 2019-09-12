package com.ryoma.coolwanandroid.di.component.fragment;

import com.ryoma.coolwanandroid.di.component.AppComponent;
import com.ryoma.coolwanandroid.di.scope.PerFragment;
import com.ryoma.coolwanandroid.view.person.LoginFragment;

import dagger.Component;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 登录注射器
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@PerFragment
@Component(dependencies = AppComponent.class)
public interface LoginFragmentComponent {
    /**
     * inject
     *
     * @param loginFragment loginFragment
     */
    void inject(LoginFragment loginFragment);
}
