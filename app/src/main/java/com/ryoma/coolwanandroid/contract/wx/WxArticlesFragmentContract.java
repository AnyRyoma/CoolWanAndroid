package com.ryoma.coolwanandroid.contract.wx;

import com.ryoma.coolwanandroid.base.presenter.IPresenter;
import com.ryoma.coolwanandroid.base.view.BaseView;
import com.ryoma.coolwanandroid.model.entity.Article;

import java.util.List;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 公众号文章接口
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface WxArticlesFragmentContract {

    interface View extends BaseView {
        /**
         * showWxArticles
         *
         * @param articleList articleList
         */
        void showWxArticles(List<Article> articleList);

        /**
         * showMoreWxArticles
         *
         * @param articleList articleList
         */
        void showMoreWxArticles(List<Article> articleList);

        void initRecyclerView();

        void initRefresh();

        void showCollectSuccess(); //收藏成功

        void showUnCollectSuccess();//取消收藏成功

        void autoRefresh();//强制刷新
    }

    interface Presenter extends IPresenter<View> {

        /**
         * loadWxArticlesData
         *
         * @param pageNum pageNum
         * @param id      id
         */
        void loadWxArticlesData(int pageNum, int id);

        /**
         * loadMoreWxArticlesData
         *
         * @param pageNum pageNum
         * @param id      id
         */
        void loadMoreWxArticlesData(int pageNum, int id);

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
