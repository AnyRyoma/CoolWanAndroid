package com.ryoma.coolwanandroid.model.http.api;

import com.ryoma.coolwanandroid.model.entity.Articles;
import com.ryoma.coolwanandroid.model.entity.BannerData;
import com.ryoma.coolwanandroid.model.entity.BaseResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author eco-ryoma
 * @date 2019/01/21
 * @description 首页模块的网络api集合
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface HomeApis {

    /**
     * 首页banner，即轮播图
     * http://www.wanandroid.com/banner/json
     *
     * @return 轮播图列表
     */
    @GET("banner/json")
    Observable<BaseResponse<List<BannerData>>> getBannerData();


    /**
     * 首页文章列表
     * http://www.wanandroid.com/article/list/1/json
     */
    @GET("article/list/{pageNum}/json")
    Observable<BaseResponse<Articles>> getArticles(@Path("pageNum") int pageNum);
}
