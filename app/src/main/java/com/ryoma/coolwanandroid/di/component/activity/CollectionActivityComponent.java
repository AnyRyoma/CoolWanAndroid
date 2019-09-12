package com.ryoma.coolwanandroid.di.component.activity;

import com.ryoma.coolwanandroid.di.component.AppComponent;
import com.ryoma.coolwanandroid.di.module.activity.CollectionActivityModule;
import com.ryoma.coolwanandroid.di.scope.PerActivity;
import com.ryoma.coolwanandroid.view.person.CollectionActivity;

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
