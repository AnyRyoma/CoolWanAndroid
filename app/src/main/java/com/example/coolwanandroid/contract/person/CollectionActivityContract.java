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
        void showCollections(List<Collection> collections); //展示收藏列表

        void showMoreCollections(List<Collection> collections);  //加载更多收藏

        void showUnCollectSuccess();//取消收藏成功

        void initToolbar();

        void initRecyclerView();

        void initRefresh();
    }

    interface Presenter extends IPresenter<View> {
        void loadCollections(int pageNum);//加载收藏数据

        void loadMoreCollections(int pageNum);//加载更多收藏数据

        void unCollectArticles(int id, int originId);//取消收藏
    }
}
