package com.example.coolwanandroid.view.person;

import android.animation.ValueAnimator;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.example.coolwanandroid.R;
import com.example.coolwanandroid.base.activity.BaseActivity;
import com.example.coolwanandroid.utils.StatusBarUtil;
import com.example.coolwanandroid.widget.ElasticOutInterpolator;
import com.scwang.smartrefresh.header.FlyRefreshHeader;
import com.scwang.smartrefresh.header.flyrefresh.FlyView;
import com.scwang.smartrefresh.header.flyrefresh.MountainSceneView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.scwang.smartrefresh.layout.util.DensityUtil;

import butterknife.BindView;

/**
 * @author eco-ryoma
 * @date 2019/01/23
 * @description 关于页
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class AboutUsActivity extends BaseActivity {

    @BindView(R.id.mountain)
    MountainSceneView mountain;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.flyView)
    FlyView flyView;
    @BindView(R.id.flyRefreshHeader)
    FlyRefreshHeader flyRefreshHeader;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.scroll_view)
    NestedScrollView scrollView;
    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    protected void inject() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about_us;
    }

    @Override
    protected void initView() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP)
            StatusBarUtil.setHeightAndPadding(this, toolbar);
        //设置标题
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);

        }
        toolbar.setNavigationOnClickListener(v -> finish());
        toolbarLayout.setTitle(getString(R.string.about_us));

        flyRefreshHeader.setUp(mountain, flyView);//绑定场景和纸飞机
        refreshLayout.setReboundInterpolator(new ElasticOutInterpolator());//设置回弹插值器，会带有弹簧震动效果
        refreshLayout.setReboundDuration(1000);//设置回弹动画时长
        refreshLayout.setOnRefreshListener(refreshLayout1 -> refreshLayout1.finishRefresh(1000));//下拉刷新监听
        //设置让Toolbar和AppBarLayout的滚动同步
        refreshLayout.setOnMultiPurposeListener(new SimpleMultiPurposeListener() {
            @Override
            public void onHeaderMoving(RefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
                super.onHeaderMoving(header, isDragging, percent, offset, headerHeight, maxDragHeight);
                if (appBar == null || toolbar == null)
                    return;
                appBar.setTranslationY(offset);
                toolbar.setTranslationY(-offset);
            }
        });
        //监听 AppBarLayout 的关闭和开启 给 FlyView（纸飞机） 和 fab 设置关闭隐藏动画
        //verticalOffset向上滑动为负值。向下滑动为正值
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean misAppbarExpand = true;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int scrollRange = appBarLayout.getTotalScrollRange();
                float fraction = 1f * (scrollRange + verticalOffset) / scrollRange;
                double minFraction = 0.1;
                double maxFraction = 0.8;
                if (fab == null || flyView == null || scrollView == null)
                    return;
                if (fraction < minFraction && misAppbarExpand) {
                    misAppbarExpand = false;
                    fab.animate().scaleX(0).scaleY(0);
                    flyView.animate().scaleX(0).scaleY(0);
                    ValueAnimator animator = ValueAnimator.ofInt(scrollView.getPaddingTop(), 0);
                    animator.setDuration(300);
                    animator.addUpdateListener(animation -> {
                        if (scrollView != null) {
                            scrollView.setPadding(0, (int) animation.getAnimatedValue(), 0, 0);
                        }
                    });
                    animator.start();
                }
                if (fraction > maxFraction && !misAppbarExpand) {
                    misAppbarExpand = true;
                    fab.animate().scaleX(1).scaleY(1);
                    flyView.animate().scaleX(1).scaleY(1);
                    ValueAnimator animator = ValueAnimator.ofInt(scrollView.getPaddingTop(), DensityUtil.dp2px(25));
                    animator.setDuration(300);
                    animator.addUpdateListener(animation -> {
                        if (scrollView != null) {
                            scrollView.setPadding(0, (int) animation.getAnimatedValue(), 0, 0);
                        }
                    });
                    animator.start();
                }
            }
        });
        fab.setOnClickListener(v -> refreshLayout.autoRefresh());//点击悬浮按钮时自动刷新
        tvContent.setText(Html.fromHtml(getString(R.string.about_us_text)));
        tvContent.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    protected void initData() {
    }
}
