package com.ryoma.coolwanandroid.di.component.fragment;

import com.ryoma.coolwanandroid.di.module.fragment.ProjectFragmentModule;
import com.ryoma.coolwanandroid.di.scope.PerFragment;
import com.ryoma.coolwanandroid.view.project.ProjectFragment;

import dagger.Subcomponent;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@PerFragment
@Subcomponent(modules = ProjectFragmentModule.class)
public interface ProjectFragmentComponent {
    void inject(ProjectFragment projectFragment);
}
