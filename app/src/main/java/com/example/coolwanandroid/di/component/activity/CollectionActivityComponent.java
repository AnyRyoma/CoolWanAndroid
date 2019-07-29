package com.example.coolwanandroid.di.component.activity;

import com.example.coolwanandroid.di.component.AppComponent;
import com.example.coolwanandroid.di.module.activity.CollectionActivityModule;
import com.example.coolwanandroid.di.scope.PerActivity;
import com.example.coolwanandroid.view.person.CollectionActivity;

import dagger.Component;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = CollectionActivityModule.class)
public interface CollectionActivityComponent {
    void inject(CollectionActivity collectionActivity);
}
