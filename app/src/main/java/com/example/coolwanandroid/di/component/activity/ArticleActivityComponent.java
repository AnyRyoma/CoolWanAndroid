package com.example.coolwanandroid.di.component.activity;

import com.example.coolwanandroid.di.component.AppComponent;
import com.example.coolwanandroid.view.home.ArticleActivity;
import com.example.coolwanandroid.di.scope.PerActivity;

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
