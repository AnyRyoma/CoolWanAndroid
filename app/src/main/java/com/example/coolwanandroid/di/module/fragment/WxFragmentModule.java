package com.example.coolwanandroid.di.module.fragment;

import android.support.v4.app.Fragment;

import com.example.coolwanandroid.di.scope.PerFragment;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 公众号Tab的实例提供
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@Module
public class WxFragmentModule {
    @Provides
    @PerFragment
    List<Fragment> provideSupportFragment() {
        return new ArrayList<>();
    }

    @Provides
    @PerFragment
    List<String> provideTitles() {
        return new ArrayList<>();
    }

    @Provides
    @PerFragment
    List<Integer> provideIds() {
        return new ArrayList<>();
    }
}
