package com.ryoma.coolwanandroid.di.component.fragment;

import com.ryoma.coolwanandroid.view.wx.WxArticlesFragment;
import com.ryoma.coolwanandroid.di.module.fragment.WxArticlesFragmentModule;
import com.ryoma.coolwanandroid.di.scope.PerFragment;

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
