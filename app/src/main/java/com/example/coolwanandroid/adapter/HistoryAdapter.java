package com.example.coolwanandroid.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.coolwanandroid.R;

import java.util.List;

/**
 * @author eco-ryoma
 * @date 2019/01/28
 * @description 历史记录的适配器
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class HistoryAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public HistoryAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        if (item == null) {
            return;
        }

        helper.setText(R.id.historyTv, item).addOnClickListener(R.id.deleteIv);
    }
}
