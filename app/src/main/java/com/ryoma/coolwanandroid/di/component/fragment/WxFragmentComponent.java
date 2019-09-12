package com.ryoma.coolwanandroid.di.component.fragment;

import com.ryoma.coolwanandroid.view.wx.WxFragment;
import com.ryoma.coolwanandroid.di.module.fragment.WxFragmentModule;
import com.ryoma.coolwanandroid.di.scope.PerFragment;

import dagger.Subcomponent;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 公众号Tab的注射器
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@PerFragment
@Subcomponent(modules = WxFragmentModule.class)
public interface WxFragmentComponent {
    void inject(WxFragment wxFragment);
}
