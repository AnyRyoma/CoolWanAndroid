package com.example.coolwanandroid.contract.search;

import com.example.coolwanandroid.base.presenter.IPresenter;
import com.example.coolwanandroid.base.view.BaseView;
import com.example.coolwanandroid.model.entity.HotKey;

import java.util.List;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 搜索界面接口
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface SearchActivityContract {

    interface View extends BaseView {
        /**
         * 显示热词布局
         *
         * @param hotKeys hotKeys
         */
        void showSearchHotKeyFlow(List<HotKey> hotKeys);

        /**
         * 显示历史记录
         *
         * @param historyList historyList
         */
        void showHistoryData(List<String> historyList);

        /**
         * 删除一条历史记录成功
         */
        void showDeleteHistory();

        /**
         * 显示历史记录为空的布局
         */
        void showHistoriesEmptyView();

        /**
         * 隐藏历史记录为空的布局
         */
        void hideHistoriesEmptyView();

        /**
         * 清空历史记录成功
         */
        void showDeleteAllHistoriesSuccess();

        /**
         * toSearchArticlesActivity
         *
         * @param key key
         */
        void toSearchArticlesActivity(String key);

        /**
         * 得到搜索栏的关键字
         *
         * @return string
         */
        String getSearchEditText();
    }

    interface Presenter extends IPresenter<View> {
        /**
         * loadSearchHotKeyData
         */
        void loadSearchHotKeyData();

        /**
         * 加载搜索历史记录
         */
        void loadHistoriesData();

        /**
         * 添加历史记录
         *
         * @param key key
         */
        void addHistory(String key);

        /**
         * 删除历史记录
         *
         * @param key key
         */
        void deleteHistory(String key);

        /**
         * 删除所有历史记录
         */
        void deleteAllHistories();
    }
}
