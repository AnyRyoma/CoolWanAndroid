package com.example.coolwanandroid.presenter.search;

import com.example.coolwanandroid.base.BaseObserver;
import com.example.coolwanandroid.base.presenter.BasePresenter;
import com.example.coolwanandroid.contract.search.SearchActivityContract;
import com.example.coolwanandroid.model.DataModel;
import com.example.coolwanandroid.model.entity.HotKey;
import com.example.coolwanandroid.utils.CommonUtils;
import com.example.coolwanandroid.utils.RxUtil;

import java.util.List;

import javax.inject.Inject;


public class SearchActivityPresenter extends BasePresenter<SearchActivityContract.View>
        implements SearchActivityContract.Presenter {

    @Inject
    public SearchActivityPresenter(DataModel model) {
        super(model);
    }

    @Override
    public void loadSearchHotKeyData() {
        addRxSubscribe(
                mModel.getHotKey()
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
