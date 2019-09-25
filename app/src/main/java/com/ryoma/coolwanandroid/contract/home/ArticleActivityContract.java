package com.ryoma.coolwanandroid.contract.home;

import com.ryoma.coolwanandroid.base.presenter.IPresenter;
import com.ryoma.coolwanandroid.base.view.BaseView;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface ArticleActivityContract {

    interface View extends BaseView {
        /**
         * 收藏成功
         */
        void showCollectSuccess();

        /**
         * 取消收藏成功
         */
        void showUnCollectSuccess();
    }

    interface Presenter extends IPresenter<View> {
        /**
         * 收藏文章
         *
         * @param id 文章id
         */
        void collectArticles(int id);

        /**
         * 取消收藏
         *
         * @param id 文章id
         */
        void unCollectArticles(int id);
    }
}
