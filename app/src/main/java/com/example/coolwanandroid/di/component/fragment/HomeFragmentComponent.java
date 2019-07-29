package com.example.coolwanandroid.di.component.fragment;

import com.example.coolwanandroid.view.home.HomeFragment;
import com.example.coolwanandroid.di.module.fragment.HomeFragmentModule;
import com.example.coolwanandroid.di.scope.PerFragment;

import dagger.Subcomponent;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description Home的注射器
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@PerFragment
@Subcomponent(modules = HomeFragmentModule.class)
public interface HomeFragmentComponent {
    void inject(HomeFragment homeFragment);
}
