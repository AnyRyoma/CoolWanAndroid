package com.example.coolwanandroid.di.component.fragment;

import com.example.coolwanandroid.view.wx.WxArticlesFragment;
import com.example.coolwanandroid.di.module.fragment.WxArticlesFragmentModule;
import com.example.coolwanandroid.di.scope.PerFragment;

import dagger.Subcomponent;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 公众号文章的注射器
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@PerFragment
@Subcomponent(modules = WxArticlesFragmentModule.class)
public interface WxArticlesFragmentComponent {
    void inject(WxArticlesFragment wxArticlesFragment);
}
