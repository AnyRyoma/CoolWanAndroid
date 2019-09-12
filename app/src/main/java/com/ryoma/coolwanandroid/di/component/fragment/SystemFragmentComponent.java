package com.ryoma.coolwanandroid.di.component.fragment;

import com.ryoma.coolwanandroid.di.module.fragment.SystemFragmentModule;
import com.ryoma.coolwanandroid.di.scope.PerFragment;
import com.ryoma.coolwanandroid.view.system.SystemFragment;

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
    /**
     * inject
     *
     * @param systemFragment systemFragment
     */
    void inject(SystemFragment systemFragment);
}
