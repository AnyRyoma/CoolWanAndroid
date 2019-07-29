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
        void showSystemArticles(List<Article> articlesList);//显示二级体系的文章

        void showMoreSystemArticles(List<Article> articlesList); //显示更多

        void showCollectSuccess(); //收藏成功

        void showUnCollectSuccess();//取消收藏成功
    }


    interface Presenter extends IPresenter<View> {
        void loadSystemArticlesData(int pageNum, int id);//加载二级体系的文章

        void loadMoreSystemArticlesData(int pageNum, int id); //加载更多

        void collectArticles(int id); //收藏首页文章

        void unCollectArticles(int id);//取消收藏
    }
}
