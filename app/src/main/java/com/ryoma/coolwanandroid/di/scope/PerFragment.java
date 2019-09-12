package com.ryoma.coolwanandroid.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description fragment的作用域
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PerFragment {
}
