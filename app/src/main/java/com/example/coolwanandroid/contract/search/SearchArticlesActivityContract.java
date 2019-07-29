package com.example.coolwanandroid.contract.search;

import com.example.coolwanandroid.base.presenter.IPresenter;
import com.example.coolwanandroid.base.view.BaseView;
import com.example.coolwanandroid.model.entity.Article;

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
        void showArticles(List<Article> articles);

        void showMoreArticles(List<Article> articles);

        void showCollectSuccess();

        void showUnCollectSuccess();

        void initToolbar();

        void initRecyclerView();

        void initRefresh();
    }

    interface Presenter extends IPresenter<View> {
        void loadArticles(int pageNum, String key);

        void loadMoreArticles(int pageNum, String key);

        void collectArticles(int id);

        void unCollectArticles(int id);
    }
}
