package com.example.coolwanandroid.model.http.api;

import com.example.coolwanandroid.model.entity.Articles;
import com.example.coolwanandroid.model.entity.BaseResponse;
import com.example.coolwanandroid.model.entity.HotKey;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @author eco-ryoma
 * @date 2019/01/28
 * @description 搜索
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface SearchApis {
    /**
     * 获取搜索热词
     * http://www.wanandroid.com//hotkey/json
     */
    @GET("hotkey/json")
    Observable<BaseResponse<List<HotKey>>> getHotKey();

    /**
     * 搜索
     * http://www.wanandroid.com/article/query/0/json
     */
    @POST("article/query/{pageNum}/json")
    @FormUrlEncoded
    Observable<BaseResponse<Articles>> getSearchArticles(@Field("k") String key,//关键字
                                                         @Path("pageNum") int pageNum//页数
    );
}
