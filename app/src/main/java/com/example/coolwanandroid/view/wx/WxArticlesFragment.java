package com.example.coolwanandroid.view.wx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.coolwanandroid.R;
import com.example.coolwanandroid.view.home.ArticleActivity;
import com.example.coolwanandroid.adapter.ArticlesAdapter;
import com.example.coolwanandroid.app.Constant;
import com.example.coolwanandroid.app.User;
import com.example.coolwanandroid.base.fragment.BaseLoadingFragment;
import com.example.coolwanandroid.contract.wx.WxArticlesFragmentContract;
import com.example.coolwanandroid.di.module.fragment.WxArticlesFragmentModule;
import com.example.coolwanandroid.model.entity.Article;
import com.example.coolwanandroid.presenter.wx.WxArticlesFragmentPresenter;
import com.example.coolwanandroid.utils.CommonUtils;
import com.example.coolwanandroid.view.MainActivity;
import com.example.coolwanandroid.view.person.LoginActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

import static android.app.Activity.RESULT_OK;

/**
 * @author eco-ryoma
 * @date 2019/01/24
 * @description 微信文章Fragment
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class WxArticlesFragment extends BaseLoadingFragment<WxArticlesFragmentPresenter>
        implements WxArticlesFragmentContract.View {

    @Inject
    WxArticlesFragmentPresenter mPresenter;
    @Inject
    LinearLayoutManager mLinearLayoutManager;
    @Inject
    List<Article> mArticleList;
    @Inject
    ArticlesAdapter mArticlesAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.normalView)
    SmartRefreshLayout mRefreshLayout;

    private int mId;
    private int mPageNum = 1;  //用于刷新
    private boolean isRefresh = false;  //是否为向上刷新
    private int mArticlesPosition = 0;//文章的序号

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_common_articles;
    }

    @Override
    protected void initView() {
        super.initView();
        getData();
        initRecyclerView();
        initRefresh();
    }

    @Override
    protected WxArticlesFragmentPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void showToast(String msg) {
        CommonUtils.toastShow(msg);
    }

    @Override
    public void showWxArticles(List<Article> articleList) {
        if (!CommonUtils.isEmptyList(mArticleList)) {
            mArticleList.clear();
        }
        mArticleList.addAll(articleList);
        mArticlesAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMoreWxArticles(List<Article> articleList) {
        if (isRefresh) {
            if (!CommonUtils.isEmptyList(mArticleList)) {
                mArticleList.clear();
            }
            mRefreshLayout.finishRefresh();
        } else {
            if (CommonUtils.isEmptyList(articleList)) {
                mRefreshLayout.finishLoadMoreWithNoMoreData();
            } else {
                mRefreshLayout.finishLoadMore(500);
            }
        }
        mArticleList.addAll(articleList);
        mArticlesAdapter.notifyDataSetChanged();
    }

    @Override
    public void initRecyclerView() {
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mArticlesAdapter);

        //文章点击效果
        mArticlesAdapter.setOnItemClickListener(((adapter, view, position) -> {
            mArticlesPosition = position;
            ArticleActivity.startActivityForResultByFragment(mActivity,
                    this,
                    mArticleList.get(position).getLink(),
                    mArticleList.get(position).getTitle(),
                    mArticleList.get(position).getId(),
                    mArticleList.get(position).isCollect(),
                    Constant.REQUEST_ARTICLE_ACTIVITY);
        }));

        //文章收藏
        mArticlesAdapter.setOnItemChildClickListener((adapter, view, position) -> {
                    mArticlesPosition = position;
                    if (!User.getInstance().isLoginStatus()) {
                        showToast(getString(R.string.first_login));
                        startActivity(new Intent(mActivity, LoginActivity.class));
                    } else {
                        if (mArticleList.get(position).isCollect()) {
                            mPresenter.unCollectArticles(mArticleList.get(position).getId());
                        } else {
                            mPresenter.collectArticles(mArticleList.get(position).getId());
                        }
                        CommonUtils.collectAnimator(mActivity, view);
                    }
                }
        );
    }

    @Override
    public void initRefresh() {
        mRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            mPageNum++;
            isRefresh = false;
            mPresenter.loadMoreWxArticlesData(mPageNum, mId);
        });
        mRefreshLayout.setOnRefreshListener(refreshLayout -> {
            mPageNum = 1;
            isRefresh = true;
            mPresenter.loadMoreWxArticlesData(1, mId);
        });
    }

    @Override
    protected void inject() {
        ((MainActivity) getActivity())
                .getComponent()
                .getWxArticlesFragmentComponent(new WxArticlesFragmentModule())
                .inject(this);
    }

    @Override
    public void showCollectSuccess() {
        showToast(getString(R.string.collect_success));
        mArticleList.get(mArticlesPosition).setCollect(true);
        mArticlesAdapter.notifyItemChanged(mArticlesPosition + mArticlesAdapter.getHeaderLayoutCount());
    }

    @Override
    public void showUnCollectSuccess() {
        showToast(getString(R.string.uncollect_success));
        mArticleList.get(mArticlesPosition).setCollect(false);
        mArticlesAdapter.notifyItemChanged(mArticlesPosition + mArticlesAdapter.getHeaderLayoutCount());
    }

    @Override
    public void autoRefresh() {
        mRefreshLayout.autoRefresh();
    }

    @Override
    protected void loadData() {
        mPresenter.subscribeEvent();
        mPresenter.loadWxArticlesData(1, mId);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK)
            return;
        Article article = mArticleList.get(mArticlesPosition);
        switch (requestCode) {
            case Constant.REQUEST_ARTICLE_ACTIVITY:
                boolean isCollect = data.getBooleanExtra(Constant.KEY_ARTICLE_COLLECT, false);
                if (isCollect != article.isCollect()) {
                    article.setCollect(isCollect);
                    mArticlesAdapter.notifyItemChanged(mArticlesPosition + mArticlesAdapter.getHeaderLayoutCount());
                }
                break;
            default:
                break;
        }
    }

    /**
     * 获取数据
     */
    private void getData() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            mId = bundle.getInt(Constant.KEY_ARTICLE_ID, -1);
        }
    }

    public static Fragment newInstance(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.KEY_ARTICLE_ID, id);
        Fragment fragment = new WxArticlesFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
