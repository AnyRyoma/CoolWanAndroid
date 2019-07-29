package com.example.coolwanandroid.di.component.activity;

import com.example.coolwanandroid.di.component.fragment.HomeFragmentComponent;
import com.example.coolwanandroid.di.component.fragment.PersonFragmentComponent;
import com.example.coolwanandroid.di.component.fragment.ProjectArticlesFragmentComponent;
import com.example.coolwanandroid.di.component.fragment.ProjectFragmentComponent;
import com.example.coolwanandroid.di.component.fragment.SystemFragmentComponent;
import com.example.coolwanandroid.di.component.fragment.WxArticlesFragmentComponent;
import com.example.coolwanandroid.di.component.fragment.WxFragmentComponent;
import com.example.coolwanandroid.view.MainActivity;
import com.example.coolwanandroid.di.component.AppComponent;
import com.example.coolwanandroid.di.module.activity.MainActivityModule;
import com.example.coolwanandroid.di.module.fragment.HomeFragmentModule;
import com.example.coolwanandroid.di.module.fragment.ProjectArticlesFragmentModule;
import com.example.coolwanandroid.di.module.fragment.ProjectFragmentModule;
import com.example.coolwanandroid.di.module.fragment.SystemFragmentModule;
import com.example.coolwanandroid.di.module.fragment.WxArticlesFragmentModule;
import com.example.coolwanandroid.di.module.fragment.WxFragmentModule;
import com.example.coolwanandroid.di.scope.PerActivity;

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
