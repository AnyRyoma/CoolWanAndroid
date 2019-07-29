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
        void showChangeNightStyle(); //显示夜间模式切换动画
    }

    interface Presenter extends IPresenter<View> {
        void setNightStyleState(boolean isNight); //设置夜间模式

        void setNoImgStyleState(boolean isNoImg); ///设置无图模式

        void setAutoCacheStyleState(boolean isAutoCache);//设置自动缓存模式
    }
}
