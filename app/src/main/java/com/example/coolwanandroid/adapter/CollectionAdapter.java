package com.example.coolwanandroid.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.coolwanandroid.R;
import com.example.coolwanandroid.model.entity.Collection;

import java.util.List;

/**
 * @author eco-ryoma
 * @date 2019/01/27
 * @description 收藏列表的适配器
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class CollectionAdapter extends BaseQuickAdapter<Collection, BaseViewHolder> {

    /**
     * 收藏 适配器
     *
     * @param layoutResId 布局id
     * @param data        数据list
     */
    public CollectionAdapter(int layoutResId, @Nullable List<Collection> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Collection item) {
        if (item == null) {
            return;
        }

        helper.setText(R.id.homeItemAuthorTv, item.getAuthor())
                .setText(R.id.homeItemDateTv, item.getNiceDate())
                .setText(R.id.homeItemTitleTv, item.getTitle())
                .setText(R.id.homeItemTypeTv, item.getChapterName())
                .setImageResource(R.id.homeItemLoveIv, R.drawable.ic_love)
                .addOnClickListener(R.id.homeItemLoveIv);
    }
}
