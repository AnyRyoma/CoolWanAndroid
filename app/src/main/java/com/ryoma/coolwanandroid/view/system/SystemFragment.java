package com.ryoma.coolwanandroid.view.system;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ryoma.coolwanandroid.R;
import com.ryoma.coolwanandroid.adapter.FirstSystemAdapter;
import com.ryoma.coolwanandroid.base.fragment.BaseLoadingFragment;
import com.ryoma.coolwanandroid.contract.system.SystemFragmentContract;
import com.ryoma.coolwanandroid.di.module.fragment.SystemFragmentModule;
import com.ryoma.coolwanandroid.model.entity.FirstSystem;
import com.ryoma.coolwanandroid.presenter.system.SystemFragmentPresenter;
import com.ryoma.coolwanandroid.utils.CommonUtils;
import com.ryoma.coolwanandroid.utils.StatusBarUtil;
import com.ryoma.coolwanandroid.view.MainActivity;
import com.ryoma.coolwanandroid.view.search.SearchActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * @author eco-ryoma
 * @date 2019/01/21
 * @description 知识体系模块
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class SystemFragment extends BaseLoadingFragment<SystemFragmentPresenter>
        implements SystemFragmentContract.View {

    @Inject
    SystemFragmentPresenter mPresenter;
    @Inject
    LinearLayoutManager mLinearLayoutManager;
    @Inject
    List<FirstSystem> mFirstSystemList;
    @Inject
    FirstSystemAdapter mFirstSystemAdapter;
    @BindView(R.id.searchTv)
    EditText mSearchTv;
    @BindView(R.id.searchIv)
    ImageView mSearchIv;
    @BindView(R.id.searchRelative)
    RelativeLayout mSearchRelative;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.normalView)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.statusBarView)
    View view;

    private boolean isRefresh = false;
    private List<String> secondSystemNames;
    private List<Integer> ids;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_nav_system;
    }

    @Override
    public void initView() {
        super.initView();
        StatusBarUtil.addStatusBarView(mActivity, view);
        initRecyclerView();
        initRefresh();
        mSearchTv.setOnClickListener(v -> toSearchActivity());
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mFirstSystemAdapter);
        secondSystemNames = new ArrayList<>();
        ids = new ArrayList<>();
        mFirstSystemAdapter.setOnItemClickListener((adapter, view, position) -> toSystemArticlesActivity(position));
    }

    private void initRefresh() {
        mRefreshLayout.setOnRefreshListener(refreshLayout -> {
            mPresenter.loadSystemData(false);
            isRefresh = true;
        });
        mRefreshLayout.setOnLoadMoreListener(refreshLayout -> refreshLayout.finishLoadMoreWithNoMoreData());
    }

    @Override
    protected void inject() {
        ((MainActivity) getActivity())
                .getComponent()
                .getSystemFragmentComponent(new SystemFragmentModule())
                .inject(this);
    }


    @Override
    protected SystemFragmentPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void showToast(String msg) {
        CommonUtils.toastShow(msg);
    }

    @Override
    protected void loadData() {
        mPresenter.loadSystemData(true);
    }


    @Override
    public void showSystemData(List<FirstSystem> firstSystemList) {
        if (isRefresh) {
            isRefresh = false;
            mRefreshLayout.finishRefresh(500);
        }
        if (!CommonUtils.isEmptyList(mFirstSystemList)) {
            mFirstSystemList.clear();
        }
        mFirstSystemList.addAll(firstSystemList);
        mFirstSystemAdapter.notifyDataSetChanged();
    }

    private void toSystemArticlesActivity(int position) {
        secondSystemNames.clear();
        ids.clear();
        for (FirstSystem.ChildrenBean secondSystem : mFirstSystemList.get(position).getChildren()) {
            secondSystemNames.add(secondSystem.getName());
            ids.add(secondSystem.getId());
        }

        SystemArticlesActivity.startActivityByData(mActivity,
                mFirstSystemList.get(position).getName(),
                secondSystemNames,
                ids);
    }

    private void toSearchActivity() {
        Intent intent = new Intent(mActivity, SearchActivity.class);

        //适配5.0以下的机型
        if (Build.VERSION.SDK_INT >= 21) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(mActivity,
                    Pair.create(mSearchTv, getString(R.string.share_edit)),
                    Pair.create(mSearchIv, getString(R.string.share_image))
            );
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }
}
