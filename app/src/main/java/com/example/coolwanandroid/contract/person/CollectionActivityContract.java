package com.example.coolwanandroid.contract.person;

import com.example.coolwanandroid.base.presenter.IPresenter;
import com.example.coolwanandroid.base.view.BaseView;
import com.example.coolwanandroid.model.entity.Collection;

import java.util.List;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 收藏界面
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface CollectionActivityContract {

    interface View extends BaseView {

        /**
         * 展示收藏列表
         *
         * @param collections collections
         */
        void showCollections(List<Collection> collections);

        /**
         * 加载更多收藏
         *
         * @param collections collections
         */
        void showMoreCollections(List<Collection> collections);

        /**
         * 取消收藏成功
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
         * 加载收藏数据
         *
         * @param pageNum pageNum
         */
        void loadCollections(int pageNum);

        /**
         * 加载更多收藏数据
         *
         * @param pageNum pageNum
         */
        void loadMoreCollections(int pageNum);

        /**
         * 取消收藏
         *
         * @param id       id
         * @param originId originId
         */
        void unCollectArticles(int id, int originId);
    }
}
