package com.example.coolwanandroid.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.coolwanandroid.R;
import com.example.coolwanandroid.model.entity.FirstSystem;

import java.util.List;

/**
 * @author eco-ryoma
 * @date 2019/01/23
 * @description 一级知识体系的适配器
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class FirstSystemAdapter extends BaseQuickAdapter<FirstSystem, BaseViewHolder> {

    public FirstSystemAdapter(int layoutResId, @Nullable List<FirstSystem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FirstSystem item) {
        if (item == null) {
            return;
        }

        String secondSystemText = "";
        for (FirstSystem.ChildrenBean secondSystem : item.getChildren()) {
            secondSystemText += secondSystem.getName() + "   ";
        }
        helper.setText(R.id.systemItemFirstTv, item.getName())
                .setText(R.id.systemItemSecondTv, secondSystemText);
    }
}
