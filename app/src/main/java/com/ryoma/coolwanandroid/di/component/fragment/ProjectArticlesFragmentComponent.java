package com.ryoma.coolwanandroid.di.component.fragment;

import com.ryoma.coolwanandroid.di.module.fragment.ProjectArticlesFragmentModule;
import com.ryoma.coolwanandroid.di.scope.PerFragment;
import com.ryoma.coolwanandroid.view.project.ProjectArticlesFragment;

import dagger.Subcomponent;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@PerFragment
@Subcomponent(modules = ProjectArticlesFragmentModule.class)
public interface ProjectArticlesFragmentComponent {
    void inject(ProjectArticlesFragment projectArticlesFragment);
}
