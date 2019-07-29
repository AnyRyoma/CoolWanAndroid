package com.example.coolwanandroid.contract;

import com.example.coolwanandroid.base.presenter.IPresenter;
import com.example.coolwanandroid.base.view.BaseView;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface MainContract {
    interface View extends BaseView {
        void showVersionUpdateDialog(String versionDetail);//显示

        void downloadApk();//下载apk

        void setApkUrl(String apkUrl);//设置新版本的下载地址
    }

    interface Presenter extends IPresenter<View> {
        void checkVersion(String currentVersion);//检查版本更新

        void setNavCurrentItem(int position);//保存页面状态，主要用于屏幕翻转

        int getNavCurrentItem();//获取页面状态
    }
}
