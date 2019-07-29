package com.example.coolwanandroid.model.http;

import com.example.coolwanandroid.model.entity.Articles;
import com.example.coolwanandroid.model.entity.BannerData;
import com.example.coolwanandroid.model.entity.BaseResponse;
import com.example.coolwanandroid.model.entity.Collections;
import com.example.coolwanandroid.model.entity.FirstSystem;
import com.example.coolwanandroid.model.entity.HotKey;
import com.example.coolwanandroid.model.entity.Login;
import com.example.coolwanandroid.model.entity.Tab;
import com.example.coolwanandroid.model.entity.Version;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 网络操作接口
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface NetworkHelper {

    /**
     * home
     */
    Observable<BaseResponse<List<BannerData>>> getBannerData();//获取轮播图的数据

    Observable<BaseResponse<Articles>> getArticles(int pageNum);//获取首页文章

    /**
     * system
     */
    Observable<BaseResponse<List<FirstSystem>>> getFirstSystemData(); //获取知识体系的一级目录

    Observable<BaseResponse<Articles>> getSecondSystemArticles(int pageNum, int id);//获取二级体系文章

    /**
     * wx
     */

    Observable<BaseResponse<List<Tab>>> getWxTabs(); //获取公众号列表

    Observable<BaseResponse<Articles>> getWxArticles(int pageNum, int id);//获取公众号文章

    /**
     * project
     */
    Observable<BaseResponse<List<Tab>>> getProjectTab();//获取项目列表

    Observable<BaseResponse<Articles>> getProjectArticles(int pageNum, int id);//获取项目列表下的文章

    /**
     * person
     */
    Observable<BaseResponse<Login>> register(String username, String password, String rePassword); //注册

    Observable<BaseResponse<Login>> login(String username, String password); //登录

    Observable<BaseResponse<Login>> logout(); //退出登录

    /**
     * collect
     */
    Observable<BaseResponse> collectArticles(int id); //收藏站内文章

    Observable<BaseResponse> unCollectArticles(int id);//文章列表取消收藏文章

    Observable<BaseResponse<Collections>> getCollectionsData(int pageNum); //获取收藏列表

    Observable<BaseResponse> unCollection(int id, int originId);//收藏列表取消收藏

    /**
     * search
     */
    Observable<BaseResponse<List<HotKey>>> getHotKey();//获取热搜关键词

    Observable<BaseResponse<Articles>> getSearchArticles(String key, int pageNum); //搜索

    /**
     * versionUpdate
     */
    Observable<Version> getVersionDetail();//获取github上最新的版本信息
}
