package com.ryoma.coolwanandroid.di.component.activity;

import com.ryoma.coolwanandroid.di.component.fragment.HomeFragmentComponent;
import com.ryoma.coolwanandroid.di.component.fragment.PersonFragmentComponent;
import com.ryoma.coolwanandroid.di.component.fragment.ProjectArticlesFragmentComponent;
import com.ryoma.coolwanandroid.di.component.fragment.ProjectFragmentComponent;
import com.ryoma.coolwanandroid.di.component.fragment.SystemFragmentComponent;
import com.ryoma.coolwanandroid.di.component.fragment.WxArticlesFragmentComponent;
import com.ryoma.coolwanandroid.di.component.fragment.WxFragmentComponent;
import com.ryoma.coolwanandroid.view.MainActivity;
import com.ryoma.coolwanandroid.di.component.AppComponent;
import com.ryoma.coolwanandroid.di.module.activity.MainActivityModule;
import com.ryoma.coolwanandroid.di.module.fragment.HomeFragmentModule;
import com.ryoma.coolwanandroid.di.module.fragment.ProjectArticlesFragmentModule;
import com.ryoma.coolwanandroid.di.module.fragment.ProjectFragmentModule;
import com.ryoma.coolwanandroid.di.module.fragment.SystemFragmentModule;
import com.ryoma.coolwanandroid.di.module.fragment.WxArticlesFragmentModule;
import com.ryoma.coolwanandroid.di.module.fragment.WxFragmentModule;
import com.ryoma.coolwanandroid.di.scope.PerActivity;

import dagger.Component;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 主要作用是注射器，并提供给子fragment的AppComponent
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);

    HomeFragmentComponent getHomeFragmentComponent(HomeFragmentModule homeFragmentModule);

    SystemFragmentComponent getSystemFragmentComponent(SystemFragmentModule systemFragmentModule);

    WxFragmentComponent getWxFragmentComponent(WxFragmentModule wxFragmentModule);

    WxArticlesFragmentComponent getWxArticlesFragmentComponent(WxArticlesFragmentModule wxArticlesFragmentModule);

    ProjectFragmentComponent getProjectFragmentComponent(ProjectFragmentModule projectFragmentModule);

    ProjectArticlesFragmentComponent getProjectArticlesFragmentComponent(ProjectArticlesFragmentModule projectArticlesModule);

    PersonFragmentComponent getPersonFragmentComponent();
}
