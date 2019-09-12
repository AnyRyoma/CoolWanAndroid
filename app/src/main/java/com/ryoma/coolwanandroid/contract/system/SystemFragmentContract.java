package com.ryoma.coolwanandroid.contract.system;

import com.ryoma.coolwanandroid.base.presenter.IPresenter;
import com.ryoma.coolwanandroid.base.view.BaseView;
import com.ryoma.coolwanandroid.model.entity.FirstSystem;

import java.util.List;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 知识体系模块下的MVP接口集合
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface SystemFragmentContract {
    interface View extends BaseView {
        /**
         * 显示知识体系的目录
         *
         * @param firstSystemList firstSystemList
         */
        void showSystemData(List<FirstSystem> firstSystemList);
    }

    interface Presenter extends IPresenter<View> {
        /**
         * 加载知识体系的数据
         *
         * @param isShowLoadingView isShowLoadingView
         */
        void loadSystemData(boolean isShowLoadingView);
    }
}
