package com.ryoma.coolwanandroid.di.module.fragment;

import android.support.v7.widget.LinearLayoutManager;

import com.ryoma.coolwanandroid.R;
import com.ryoma.coolwanandroid.app.App;
import com.ryoma.coolwanandroid.adapter.ArticlesAdapter;
import com.ryoma.coolwanandroid.di.scope.PerFragment;
import com.ryoma.coolwanandroid.model.entity.Article;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 二级知识体系文章
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@Module
public class SystemArticlesFragmentModule {
    @Provides
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(App.getContext());
    }


    @Provides
    @PerFragment
    List<Article> provideArticles() {
        return new ArrayList<>();
    }

    @Provides
    @PerFragment
    ArticlesAdapter provideArticlesAdapter(List<Article> articles) {
        return new ArticlesAdapter(R.layout.item_home_list, articles);
    }
}
