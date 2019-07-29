package com.example.coolwanandroid.di.component.fragment;

import com.example.coolwanandroid.view.person.RegisterFragment;
import com.example.coolwanandroid.di.component.AppComponent;
import com.example.coolwanandroid.di.scope.PerFragment;

import dagger.Component;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 注册注射器
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@PerFragment
@Component(dependencies = AppComponent.class)
public interface RegisterFragmentComponent {
    void inject(RegisterFragment registerFragment);
}
