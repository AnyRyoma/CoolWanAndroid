package com.ryoma.coolwanandroid.di.component.fragment;

import com.ryoma.coolwanandroid.view.person.PersonFragment;
import com.ryoma.coolwanandroid.di.scope.PerFragment;

import dagger.Subcomponent;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 个人模块
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@PerFragment
@Subcomponent()
public interface PersonFragmentComponent {
    void inject(PersonFragment personFragment);
}
