package com.ryoma.coolwanandroid.contract.search;

import com.ryoma.coolwanandroid.base.presenter.IPresenter;
import com.ryoma.coolwanandroid.base.view.BaseView;
import com.ryoma.coolwanandroid.model.entity.Article;

import java.util.List;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 搜索文章
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface SearchArticlesActivityContract {
    interface View extends BaseView {

        /**
         * showArticles
         *
         * @param articles articles
         */
        void showArticles(List<Article> articles);

        /**
         * showMoreArticles
         *
         * @param articles articles
         */
        void showMoreArticles(List<Article> articles);

        /**
         * showCollectSuccess
         */
        void showCollectSuccess();

        /**
         * showUnCollectSuccess
         */
        void showUnCollectSuccess();

        /**
         * initToolbar
         */
        void initToolbar();

        /**
         * initRecyclerView
         */
        void initRecyclerView();

        /**
         * initRefresh
         */
        void initRefresh();
    }

    interface Presenter extends IPresenter<View> {

        /**
         * loadArticles
         *
         * @param pageNum pageNum
         * @param key     key
         */
        void loadArticles(int pageNum, String key);

        /**
         * loadMoreArticles
         *
         * @param pageNum pageNum
         * @param key     key
         */
        void loadMoreArticles(int pageNum, String key);

        /**
         * collectArticles
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
