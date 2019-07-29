package com.example.coolwanandroid.model.http.api;

import com.example.coolwanandroid.model.entity.Articles;
import com.example.coolwanandroid.model.entity.BaseResponse;
import com.example.coolwanandroid.model.entity.Tab;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author eco-ryoma
 * @date 2019/01/24
 * @description 项目api集合
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface ProjectApis {
    /**
     * 获得大概项目列表
     * http://www.wanandroid.com/project/tree/json
     */
    @GET("project/tree/json")
    Observable<BaseResponse<List<Tab>>> getProjectTab();

    /**
     * 获得详细项目列表
     * http://www.wanandroid.com/project/list/1/json?cid=294
     */
    @GET("project/list/{pageNum}/json")
    Observable<BaseResponse<Articles>> getProjectArticles(@Path("pageNum") int pageNum,//页数
                                                          @Query("cid") int id//具体项目列表的id
    );
}
