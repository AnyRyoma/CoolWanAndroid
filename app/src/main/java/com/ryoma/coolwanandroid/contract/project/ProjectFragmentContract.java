package com.ryoma.coolwanandroid.contract.project;

import com.ryoma.coolwanandroid.base.presenter.IPresenter;
import com.ryoma.coolwanandroid.base.view.BaseView;
import com.ryoma.coolwanandroid.model.entity.Tab;

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
