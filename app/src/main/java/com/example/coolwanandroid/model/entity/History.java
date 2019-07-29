package com.example.coolwanandroid.model.entity;

import org.litepal.crud.LitePalSupport;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 搜索历史
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class History extends LitePalSupport {
    private int id;
    private String key;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
