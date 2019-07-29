package com.example.coolwanandroid.di.component.activity;

import com.example.coolwanandroid.view.person.SettingActivity;
import com.example.coolwanandroid.di.component.AppComponent;
import com.example.coolwanandroid.di.scope.PerActivity;

import dagger.Component;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 设置注射器
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@PerActivity
@Component(dependencies = AppComponent.class)
public interface SettingActivityComponent {
    void inject(SettingActivity settingActivity);
}
