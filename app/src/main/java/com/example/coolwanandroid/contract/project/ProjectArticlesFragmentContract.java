package com.example.coolwanandroid.contract.project;

import com.example.coolwanandroid.base.presenter.IPresenter;
import com.example.coolwanandroid.base.view.BaseView;
import com.example.coolwanandroid.model.entity.Article;

import java.util.List;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 项目文章Mvp接口集合
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface ProjectArticlesFragmentContract {

    interface View extends BaseView {
        /**
         * 获取article 列表
         *
         * @param articleList articleList
         */
        void showProjectArticles(List<Article> articleList);

        /**
         * 获取更多文章
         *
         * @param articleList articleList
         */
        void showMoreProjectArticles(List<Article> articleList);

        /**
         * 初始化RecyclerView
         */
        void initRecyclerView();

        /**
         * initRefresh
         */
        void initRefresh();

        /**
         * 收藏成功
         */
        void showCollectSuccess();

        /**
         * 取消收藏成功
         */
        void showUnCollectSuccess();

        /**
         * autoRefresh
         */
        void autoRefresh();
    }

    interface Presenter extends IPresenter<View> {

        /**
         * loadProjectArticlesData
         *
         * @param pageNum pageNum
         * @param id      id
         */
        void loadProjectArticlesData(int pageNum, int id);

        /**
         * loadMoreProjectArticlesData
         *
         * @param pageNum pageNum
         * @param id      id
         */
        void loadMoreProjectArticlesData(int pageNum, int id);

        /**
         * 收藏首页文章
         *
         * @param id id
         */
        void collectArticles(int id);

        /**
         * unCollectArticles
         *
         * @param id id
         */
        void unCollectArticles(int id);
    }
}
