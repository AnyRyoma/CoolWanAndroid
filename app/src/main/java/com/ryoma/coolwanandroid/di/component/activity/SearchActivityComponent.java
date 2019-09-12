package com.ryoma.coolwanandroid.di.component.activity;

import com.ryoma.coolwanandroid.di.component.AppComponent;
import com.ryoma.coolwanandroid.di.scope.PerActivity;
import com.ryoma.coolwanandroid.view.search.SearchActivity;

import dagger.Component;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 搜索关键词
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@PerActivity
@Component(dependencies = AppComponent.class)
public interface SearchActivityComponent {
    void inject(SearchActivity searchActivity);
}
