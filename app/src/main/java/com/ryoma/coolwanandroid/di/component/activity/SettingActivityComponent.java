package com.ryoma.coolwanandroid.di.component.activity;

import com.ryoma.coolwanandroid.view.person.SettingActivity;
import com.ryoma.coolwanandroid.di.component.AppComponent;
import com.ryoma.coolwanandroid.di.scope.PerActivity;

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
