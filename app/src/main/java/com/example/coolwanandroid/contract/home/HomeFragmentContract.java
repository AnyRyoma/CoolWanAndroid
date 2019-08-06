package com.example.coolwanandroid.contract.home;

import com.example.coolwanandroid.base.presenter.IPresenter;
import com.example.coolwanandroid.base.view.BaseView;
import com.example.coolwanandroid.model.entity.Article;
import com.example.coolwanandroid.model.entity.BannerData;

import java.util.List;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 首页的MVP接口集合
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface HomeFragmentContract {
    interface View extends BaseView {
        void showBannerData(List<BannerData> bannerDataList); //展示轮播图

        void showArticles(List<Article> articlesList); //展示首页文章

        void showMoreArticles(List<Article> articleList);  //加载更多文章

        void showCollectSuccess(); //收藏成功

        void showUnCollectSuccess();//取消收藏成功

        void autoRefresh();//强制刷新

        void collect();//收藏操作

    }


    interface Presenter extends IPresenter<View> {
        /**
         * 加载首页banner数据
         */
        void loadBannerData();

        /**
         * 加载首页文章数据
         *
         * @param pageNum 页面id
         */
        void loadArticles(int pageNum);

        /**
         * 加载更多首页文章
         *
         * @param pageNum
         */
        void loadMoreArticles(int pageNum);

        void collectArticles(int id); //收藏首页文章

        void unCollectArticles(int id);//取消收藏
    }
}
