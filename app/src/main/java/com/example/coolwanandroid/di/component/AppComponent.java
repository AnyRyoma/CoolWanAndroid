package com.example.coolwanandroid.di.component;

import com.example.coolwanandroid.app.App;
import com.example.coolwanandroid.di.module.AppModule;
import com.example.coolwanandroid.model.DataModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(App app); //注入自定义的application

    //暴露方法
    App getApp();

    DataModel getDataModel();
}
