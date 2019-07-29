package com.example.coolwanandroid.di.component.activity;

import com.example.coolwanandroid.di.component.AppComponent;
import com.example.coolwanandroid.di.module.activity.SearchArticlesActivityModule;
import com.example.coolwanandroid.di.scope.PerActivity;
import com.example.coolwanandroid.view.search.SearchArticlesActivity;

import dagger.Component;


/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 搜索文章 
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = SearchArticlesActivityModule.class)
public interface SearchArticlesActivityComponent {
    void inject(SearchArticlesActivity searchArticlesActivity);
}
