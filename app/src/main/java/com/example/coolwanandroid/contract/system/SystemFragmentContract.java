package com.example.coolwanandroid.contract.system;

import com.example.coolwanandroid.base.presenter.IPresenter;
import com.example.coolwanandroid.base.view.BaseView;
import com.example.coolwanandroid.model.entity.FirstSystem;

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
        void showSystemData(List<FirstSystem> firstSystemList); //显示知识体系的目录
    }

    interface Presenter extends IPresenter<View> {
        void loadSystemData(boolean isShowLoadingView); //加载知识体系的数据
    }
}
