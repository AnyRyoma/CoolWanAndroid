package com.example.coolwanandroid.di.component.fragment;

import com.example.coolwanandroid.di.module.fragment.ProjectFragmentModule;
import com.example.coolwanandroid.di.scope.PerFragment;
import com.example.coolwanandroid.view.project.ProjectFragment;

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
