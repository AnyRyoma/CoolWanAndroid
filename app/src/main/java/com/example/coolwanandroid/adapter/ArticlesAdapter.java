package com.example.coolwanandroid.adapter;

import android.text.Html;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.coolwanandroid.R;
import com.example.coolwanandroid.model.entity.Article;

import java.util.List;

/**
 * @author eco-ryoma
 * @date 2019/01/22
 * @description 文章的适配器
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class ArticlesAdapter extends BaseQuickAdapter<Article, BaseViewHolder> {

    /**
     * 适配器构造方法
     *
     * @param layoutResId 布局id
     * @param data        数据list
     */
    public ArticlesAdapter(int layoutResId, List<Article> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Article item) {
        if (item == null) {
            return;
        }

        helper.setText(R.id.homeItemAuthorTv, item.getAuthor())
                .setText(R.id.homeItemDateTv, item.getNiceDate())
                .setText(R.id.homeItemTitleTv, Html.fromHtml(item.getTitle()))
                .setText(R.id.homeItemTypeTv, item.getSuperChapterName() + " / " + item.getChapterName())
                .addOnClickListener(R.id.homeItemLoveIv);

        if (item.isCollect()) {
            helper.getView(R.id.homeItemLoveIv).setSelected(true);
        } else {
            helper.getView(R.id.homeItemLoveIv).setSelected(false);
        }
    }
}
