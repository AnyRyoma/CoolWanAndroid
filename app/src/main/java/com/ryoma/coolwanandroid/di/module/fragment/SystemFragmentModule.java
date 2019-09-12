package com.ryoma.coolwanandroid.di.module.fragment;

import android.support.v7.widget.LinearLayoutManager;

import com.ryoma.coolwanandroid.R;
import com.ryoma.coolwanandroid.app.App;
import com.ryoma.coolwanandroid.adapter.FirstSystemAdapter;
import com.ryoma.coolwanandroid.di.scope.PerFragment;
import com.ryoma.coolwanandroid.model.entity.FirstSystem;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 知识体系实例提供
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@Module
public class SystemFragmentModule {
    @Provides
    @PerFragment
    List<FirstSystem> provideFirstSystemList() {
        return new ArrayList<>();
    }

    @Provides
    @PerFragment
    FirstSystemAdapter provideFirstSystemAdapter(List<FirstSystem> firstSystemList) {
        return new FirstSystemAdapter(R.layout.item_system_list, firstSystemList);
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(App.getContext());
    }
}
