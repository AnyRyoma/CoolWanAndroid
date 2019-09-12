package com.ryoma.coolwanandroid.di.component.activity;

import com.ryoma.coolwanandroid.di.component.AppComponent;
import com.ryoma.coolwanandroid.view.home.ArticleActivity;
import com.ryoma.coolwanandroid.di.scope.PerActivity;

import dagger.Component;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@PerActivity
@Component(dependencies = AppComponent.class)
public interface ArticleActivityComponent {
    void inject(ArticleActivity articleActivity);
}
