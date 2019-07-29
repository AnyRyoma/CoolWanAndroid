package com.example.coolwanandroid.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.coolwanandroid.R;
import com.example.coolwanandroid.model.entity.Article;
import com.example.coolwanandroid.utils.ImageUtil;

import java.util.List;

/**
 * @author eco-ryoma
 * @date 2019/01/24
 * @description 项目item的适配器
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class ProjectAdapter extends BaseQuickAdapter<Article, BaseViewHolder> {

    public ProjectAdapter(int layoutResId, @Nullable List<Article> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Article item) {

        // 判空处理
        if (item == null) {
            return;
        }

        helper.setText(R.id.projectTitleTv, item.getTitle())
                .setText(R.id.projectDecsTv, item.getDesc())
                .setText(R.id.projectAuthorTv, item.getAuthor())
                .setText(R.id.projectDateTv, item.getNiceDate())
                .addOnClickListener(R.id.projectLoveIv);

        ImageUtil.loadImage(mContext, helper.getView(R.id.projectPicIv), item.getEnvelopePic());
        if (item.isCollect()) {
            helper.getView(R.id.projectLoveIv).setSelected(true);
        } else {
            helper.getView(R.id.projectLoveIv).setSelected(false);
        }
    }

}
