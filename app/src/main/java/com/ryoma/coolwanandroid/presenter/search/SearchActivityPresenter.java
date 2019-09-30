package com.ryoma.coolwanandroid.presenter.search;

import com.ryoma.coolwanandroid.base.BaseObserver;
import com.ryoma.coolwanandroid.base.presenter.BasePresenter;
import com.ryoma.coolwanandroid.contract.search.SearchActivityContract;
import com.ryoma.coolwanandroid.model.DataModel;
import com.ryoma.coolwanandroid.model.entity.HotKey;
import com.ryoma.coolwanandroid.utils.CommonUtils;
import com.ryoma.coolwanandroid.utils.RxUtil;

import java.util.List;

import javax.inject.Inject;

/**
 * @author eco-ryoma
 * @date 2019/09/30
 * @description SearchActivityPresenter
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class SearchActivityPresenter extends BasePresenter<SearchActivityContract.View>
        implements SearchActivityContract.Presenter {

    @Inject
    public SearchActivityPresenter(DataModel model) {
        super(model);
    }

    @Override
    public void loadSearchHotKeyData() {
        addRxSubscribe(mModel.getHotKey()
                .compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.handleResult())
                .subscribeWith(new BaseObserver<List<HotKey>>(mView, false, false) {
                    @Override
                    public void onNext(List<HotKey> hotKeys) {
                        mView.showSearchHotKeyFlow(hotKeys);
                    }
                })
        );
    }

    @Override
    public void loadHistoriesData() {
        List<String> historyList = mModel.getAllHistory();
        if (CommonUtils.isEmptyList(historyList)) {
            mView.showHistoriesEmptyView();
        } else {
            mView.hideHistoriesEmptyView();
            mView.showHistoryData(historyList);
        }
    }

    @Override
    public void addHistory(String key) {
        if (mModel.isExistHistory(key)) {
            mModel.deleteOneHistory(key);
        }
        mModel.addHistory(key);
    }

    @Override
    public void deleteHistory(String key) {
        if (mModel.deleteOneHistory(key) == 1)
            mView.showDeleteHistory();
    }

    @Override
    public void deleteAllHistories() {
        if (mModel.deleteAllHistory() > 0) {
            mView.showDeleteAllHistoriesSuccess();
        }
    }
}
