package com.example.coolwanandroid.contract.system;

import com.example.coolwanandroid.base.presenter.IPresenter;
import com.example.coolwanandroid.base.view.BaseView;
import com.example.coolwanandroid.model.entity.Article;

import java.util.List;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 二级知识体系文章的MVP接口集合
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface SystemArticlesFragmentContract {
    interface View extends BaseView {

        /**
         * 显示二级体系的文章
         *
         * @param articlesList articlesList
         */
        void showSystemArticles(List<Article> articlesList);

        /**
         * 显示更多
         *
         * @param articlesList articlesList
         */
        void showMoreSystemArticles(List<Article> articlesList);

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
         * 加载二级体系的文章
         *
         * @param pageNum pageNum
         * @param id      id
         */
        void loadSystemArticlesData(int pageNum, int id);

        /**
         * 加载更多
         *
         * @param pageNum pageNum
         * @param id      id
         */
        void loadMoreSystemArticlesData(int pageNum, int id);

        /**
         * 收藏首页文章
         *
         * @param id id
         */
        void collectArticles(int id);

        /**
         * 取消收藏
         *
         * @param id id
         */
        void unCollectArticles(int id);
    }
}
