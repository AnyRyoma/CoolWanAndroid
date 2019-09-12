package com.ryoma.coolwanandroid.model.http.api;

import com.ryoma.coolwanandroid.model.entity.Articles;
import com.ryoma.coolwanandroid.model.entity.BaseResponse;
import com.ryoma.coolwanandroid.model.entity.Tab;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 公共号api集合
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface WxApis {
    /**
     * 获得公众号tab
     * http://wanandroid.com/wxarticle/chapters/json
     */
    @GET("wxarticle/chapters/json")
    Observable<BaseResponse<List<Tab>>> getWxTabs();

    /**
     * 获得某个公共号的文章列表
     * http://wanandroid.com/wxarticle/list/408/1/json
     * pageNum默认从1开始
     */
    @GET("wxarticle/list/{id}/{pageNum}/json")
    Observable<BaseResponse<Articles>> getWxArticles(
            @Path("pageNum") int pageNum,//某个公众号的页码
            @Path("id") int id //某个公众号id
    );
}
