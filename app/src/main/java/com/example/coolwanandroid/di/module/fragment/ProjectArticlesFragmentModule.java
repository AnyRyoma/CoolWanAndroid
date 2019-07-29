package com.example.coolwanandroid.di.module.fragment;

import android.support.v7.widget.LinearLayoutManager;

import com.example.coolwanandroid.R;
import com.example.coolwanandroid.app.App;
import com.example.coolwanandroid.adapter.ProjectAdapter;
import com.example.coolwanandroid.di.scope.PerFragment;
import com.example.coolwanandroid.model.entity.Article;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 项目文章
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@Module
public class ProjectArticlesFragmentModule {
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
    ProjectAdapter provideProjectAdapter(List<Article> articles) {
        return new ProjectAdapter(R.layout.item_project_list, articles);
    }
}
