package com.example.coolwanandroid.di.component.fragment;

import com.example.coolwanandroid.di.component.AppComponent;
import com.example.coolwanandroid.di.module.fragment.SystemArticlesFragmentModule;
import com.example.coolwanandroid.di.scope.PerFragment;
import com.example.coolwanandroid.view.system.SystemArticlesFragment;

import dagger.Component;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 二级知识体系文章的注射器
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@PerFragment
@Component(modules = SystemArticlesFragmentModule.class, dependencies = AppComponent.class)
public interface SystemArticlesFragmentComponent {
    void inject(SystemArticlesFragment systemArticlesFragment);
}
