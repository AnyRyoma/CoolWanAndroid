package com.example.coolwanandroid.model.http.api;

import com.example.coolwanandroid.model.entity.BaseResponse;
import com.example.coolwanandroid.model.entity.Collections;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @author eco-ryoma
 * @date 2019/01/26
 * @description 收藏功能接口
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface CollectApis {
    /**
     * 收藏站内文章
     * http://www.wanandroid.com/lg/collect/1165/json
     *
     * @param id 文章id
     * @return BaseResponse
     */
    @POST("lg/collect/{id}/json")
    Observable<BaseResponse> collectArticles(@Path("id") int id);

    /**
     * 文章取消收藏
     * http://www.wanandroid.com/lg/uncollect_originId/2333/json
     *
     * @param id 文章id
     * @return BaseResponse
     */
    @POST("lg/uncollect_originId/{id}/json")
    Observable<BaseResponse> unCollectArticles(@Path("id") int id);

    /**
     * 获取收藏列表
     * http://www.wanandroid.com/lg/collect/list/{pageNum}/json
     *
     * @param pageNum 页面
     * @return BaseResponse<Collections>
     */
    @GET("lg/collect/list/{pageNum}/json")
    Observable<BaseResponse<Collections>> getCollectionsData(@Path("pageNum") int pageNum);

    /**
     * 收藏列表下取消收藏
     * http://www.wanandroid.com/lg/uncollect/2805/json
     *
     * @param id       收藏在我的收藏列表的id
     * @param originId 收藏在原始文章列表的id)
     * @return BaseResponse
     */
    @POST("lg/uncollect/{id}/json")
    @FormUrlEncoded
    Observable<BaseResponse> unCollection(@Path("id") int id,
                                          @Field("originId") int originId);
}
