package com.example.coolwanandroid.base.activity;

import com.example.coolwanandroid.base.presenter.IPresenter;


/**
 * @author eco-ryoma
 * @date 2019/01/29
 * @description mvp activity base
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public abstract class BaseMvpActivity<T extends IPresenter> extends BaseActivity {
    /**
     * 获取 presenter
     *
     * @return T
     */
    protected abstract T getPresenter();

    protected T mPresenter;

    @Override
    protected void initView() {
        mPresenter = getPresenter();
        mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }
}
