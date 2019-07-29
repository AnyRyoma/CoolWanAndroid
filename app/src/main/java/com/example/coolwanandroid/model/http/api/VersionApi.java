package com.example.coolwanandroid.model.http.api;

import com.example.coolwanandroid.model.entity.Version;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 版本api
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface VersionApi {
    /**
     * 自己github上的下载地址
     * 格式为https://api.github.com/repos/userName/仓库名称/releases/latest
     */
    @GET("https://api.github.com/repos/jsyjst/Yuan-WanAndroid/releases/latest")
    Observable<Version> getVersionDetail();
}
