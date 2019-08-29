package com.example.coolwanandroid.contract.project;

import com.example.coolwanandroid.base.presenter.IPresenter;
import com.example.coolwanandroid.base.view.BaseView;
import com.example.coolwanandroid.model.entity.Tab;

import java.util.List;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 项目模块的Mvp接口集合
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface ProjectFragmentContract {
    interface View extends BaseView {
        /**
         * showProjectTab
         *
         * @param tabList tabList
         */
        void showProjectTab(List<Tab> tabList);
    }

    interface Presenter extends IPresenter<View> {
        /**
         * loadProjectTabData
         */
        void loadProjectTabData();
    }
}
