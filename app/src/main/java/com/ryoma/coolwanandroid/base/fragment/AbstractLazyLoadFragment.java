package com.ryoma.coolwanandroid.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

/**
 * @author eco-ryoma
 * @date 2019/01/21
 * @description fragment实现懒加载
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public abstract class AbstractLazyLoadFragment extends Fragment {
    /**
     * 布局是否被创建
     */
    private boolean isViewCreated = false;

    /**
     * 数据是否加载
     */
    private boolean isLoadData = false;

    /**
     * 是否第一次可见
     */
    private boolean isFirstVisible = true;
    private String TAG = "BaseLazy";

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        isViewCreated = true;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (isFragmentVisible(this) && this.isAdded()) {
            if (this.getParentFragment() == null || isFragmentVisible(this.getParentFragment())) {
                onLazyLoadData();
                isLoadData = true;
                if (isFirstVisible) {
                    isFirstVisible = false;
                }
            }
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, "setUserVisibleHint(): "
                + " hide: " + this.isHidden()
                + " add :" + this.isAdded()
                + " visible: " + this.isVisible()
                + " resumed: " + this.isResumed());
        if (isFragmentVisible(this) && !isLoadData && isViewCreated && this.isAdded()) {
            onLazyLoadData();
            isLoadData = true;
        }
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d(TAG, "onHiddenChanged(): "
                + " hide: " + this.isHidden()
                + " add :" + this.isAdded()
                + " visible: " + this.isVisible()
                + " resumed: " + this.isResumed());
        //onHiddenChanged调用在Resumed之前，所以此时可能fragment被add, 但还没resumed
        if (!hidden && !this.isResumed())
            return;
        //使用hide和show时，fragment的所有生命周期方法都不会调用，除了onHiddenChanged（）
        if (!hidden && isFirstVisible && this.isAdded()) {
            onLazyLoadData();
            isFirstVisible = false;
        }
    }

    protected void onLazyLoadData() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isViewCreated = false;
        isLoadData = false;
        isFirstVisible = true;
    }

    /**
     * 当前Fragment是否可见
     */
    private boolean isFragmentVisible(Fragment fragment) {
        return !fragment.isHidden() && fragment.getUserVisibleHint();
    }
}
