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
        void showProjectArticles(List<Article> articleList);

        void showMoreProjectArticles(List<Article> articleList);

        void initRecyclerView();

        void initRefresh();

        void showCollectSuccess(); //收藏成功

        void showUnCollectSuccess();//取消收藏成功

        void autoRefresh();
    }

    interface Presenter extends IPresenter<View> {
        void loadProjectArticlesData(int pageNum, int id);

        void loadMoreProjectArticlesData(int pageNum, int id);

        void collectArticles(int id); //收藏首页文章

        void unCollectArticles(int id);//取消收藏
    }
}
