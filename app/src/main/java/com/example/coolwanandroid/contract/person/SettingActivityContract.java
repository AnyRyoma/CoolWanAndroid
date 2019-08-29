package com.example.coolwanandroid.contract.person;

import com.example.coolwanandroid.base.presenter.IPresenter;
import com.example.coolwanandroid.base.view.BaseView;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 设置接口集合
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface SettingActivityContract {
    interface View extends BaseView {
        /**
         * 显示夜间模式切换动画
         */
        void showChangeNightStyle();
    }

    interface Presenter extends IPresenter<View> {
        /**
         * 设置夜间模式
         *
         * @param isNight isNight
         */
        void setNightStyleState(boolean isNight);

        /**
         * 设置无图模式
         *
         * @param isNoImg isNoImg
         */
        void setNoImgStyleState(boolean isNoImg);

        /**
         * setAutoCacheStyleState
         *
         * @param isAutoCache isAutoCache
         */
        void setAutoCacheStyleState(boolean isAutoCache);
    }
}
