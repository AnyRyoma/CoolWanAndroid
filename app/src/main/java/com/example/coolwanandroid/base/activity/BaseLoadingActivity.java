package com.example.coolwanandroid.base.activity;

import android.view.View;
import android.view.ViewGroup;

import com.example.coolwanandroid.R;
import com.example.coolwanandroid.base.presenter.IPresenter;
import com.example.coolwanandroid.utils.TypefacesUtil;
import com.example.coolwanandroid.widget.Lead;
import com.example.coolwanandroid.widget.LeadTextView;

import static com.example.coolwanandroid.app.Constant.ERROR_STATE;
import static com.example.coolwanandroid.app.Constant.LOADING_STATE;
import static com.example.coolwanandroid.app.Constant.NORMAL_STATE;

/**
 * @author eco-ryoma
 * @date 2019/01/28
 * @description 加载页
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public abstract class BaseLoadingActivity<T extends IPresenter> extends BaseMvpActivity<T> {
    private View mLoadingView;
    private ViewGroup mNormalView;
    private LeadTextView mLoadingText;
    private Lead lead;

    private int mCurrentState = NORMAL_STATE;

    @Override
    public void initView() {
        super.initView();
        mNormalView = findViewById(R.id.normalView);
        if (mNormalView == null) {
            throw new IllegalStateException("The subclass of BaseLoadFragment must contain a View it's id is named normal_view");
        }
        if (!(mNormalView.getParent() instanceof ViewGroup)) {
            throw new IllegalStateException("mNormalView's ParentView should be a ViewGroup");
        }
        ViewGroup parent = (ViewGroup) mNormalView.getParent();
        View.inflate(this, R.layout.loading_view, parent);
        mLoadingView = parent.findViewById(R.id.loadingView);
        mLoadingText = mLoadingView.findViewById(R.id.loadingText);
        mLoadingText.setTypeface(TypefacesUtil.get(this, "Satisfy-Regular.ttf"));
        lead = new Lead(1000);
        mNormalView.setVisibility(View.VISIBLE);
        mLoadingView.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        if (lead != null) {
            lead.cancel();
        }
        super.onDestroy();
    }

    @Override
    public void showLoading() {
        if (mCurrentState == LOADING_STATE) {
            return;
        }

        hideCurrentViewByState();
        mCurrentState = LOADING_STATE;
        mLoadingView.setVisibility(View.VISIBLE);
        lead.start(mLoadingText);
    }

    @Override
    public void showNormalView() {
        if (mCurrentState == NORMAL_STATE) {
            return;
        }

        hideCurrentViewByState();
        mCurrentState = NORMAL_STATE;
        mNormalView.setVisibility(View.VISIBLE);
    }

    /**
     * 隐藏当前布局根据mCurrentState
     */
    private void hideCurrentViewByState() {
        switch (mCurrentState) {
            case NORMAL_STATE:
                mNormalView.setVisibility(View.GONE);
                break;
            case LOADING_STATE:
                lead.cancel();
                mLoadingView.setVisibility(View.GONE);
                break;
            case ERROR_STATE:
                break;
            default:
                break;
        }
    }
}
