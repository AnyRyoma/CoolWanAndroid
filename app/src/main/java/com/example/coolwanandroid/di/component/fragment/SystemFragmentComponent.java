package com.example.coolwanandroid.di.component.fragment;

import com.example.coolwanandroid.di.module.fragment.SystemFragmentModule;
import com.example.coolwanandroid.di.scope.PerFragment;
import com.example.coolwanandroid.view.system.SystemFragment;

import dagger.Subcomponent;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@PerFragment
@Subcomponent(modules = SystemFragmentModule.class)
public interface SystemFragmentComponent {
    void inject(SystemFragment systemFragment);
}
