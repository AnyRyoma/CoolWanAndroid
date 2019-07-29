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
import com.example.coolwanandroid.model.http.api.CollectApis;
import com.example.coolwanandroid.model.http.api.HomeApis;
import com.example.coolwanandroid.model.http.api.PersonApis;
import com.example.coolwanandroid.model.http.api.ProjectApis;
import com.example.coolwanandroid.model.http.api.SearchApis;
import com.example.coolwanandroid.model.http.api.SystemApis;
import com.example.coolwanandroid.model.http.api.VersionApi;
import com.example.coolwanandroid.model.http.api.WxApis;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 对外隐藏进行网络请求的实现细节
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class NetworkHelperImpl implements NetworkHelper {
    private HomeApis mHomeApis;
    private SystemApis mSystemApis;
    private WxApis mWxApis;
    private ProjectApis mProjectApis;
    private PersonApis mPersonApis;
    private CollectApis mCollectApis;
    private SearchApis mSearchApis;
    private VersionApi mVersionApi;

    @Inject
    public NetworkHelperImpl(HomeApis homeApis,
                             SystemApis systemApis,
                             WxApis wxApis,
                             ProjectApis projectApis,
                             PersonApis personApis,
                             CollectApis collectApis,
                             SearchApis searchApis,
                             VersionApi versionApi) {
        mHomeApis = homeApis;
        mSystemApis = systemApis;
        mWxApis = wxApis;
        mProjectApis = projectApis;
        mPersonApis = personApis;
        mCollectApis = collectApis;
        mSearchApis = searchApis;
        mVersionApi = versionApi;
    }

    @Override
    public Observable<BaseResponse<List<BannerData>>> getBannerData() {
        return mHomeApis.getBannerData();
    }

    @Override
    public Observable<BaseResponse<Articles>> getArticles(int pageNum) {
        return mHomeApis.getArticles(pageNum);
    }

    @Override
    public Observable<BaseResponse<List<FirstSystem>>> getFirstSystemData() {
        return mSystemApis.getFirstSystemData();
    }

    @Override
    public Observable<BaseResponse<Articles>> getSecondSystemArticles(int pageNum, int id) {
        return mSystemApis.getSecondSystemArticles(pageNum, id);
    }

    @Override
    public Observable<BaseResponse<List<Tab>>> getWxTabs() {
        return mWxApis.getWxTabs();
    }

    @Override
    public Observable<BaseResponse<Articles>> getWxArticles(int pageNum, int id) {
        return mWxApis.getWxArticles(pageNum, id);
    }

    @Override
    public Observable<BaseResponse<List<Tab>>> getProjectTab() {
        return mProjectApis.getProjectTab();
    }

    @Override
    public Observable<BaseResponse<Articles>> getProjectArticles(int pageNum, int id) {
        return mProjectApis.getProjectArticles(pageNum, id);
    }

    @Override
    public Observable<BaseResponse<Login>> register(String username, String password, String rePassword) {
        return mPersonApis.register(username, password, rePassword);
    }

    @Override
    public Observable<BaseResponse<Login>> login(String username, String password) {
        return mPersonApis.login(username, password);
    }

    @Override
    public Observable<BaseResponse<Login>> logout() {
        return mPersonApis.logout();
    }

    @Override
    public Observable<BaseResponse> collectArticles(int id) {
        return mCollectApis.collectArticles(id);
    }

    @Override
    public Observable<BaseResponse> unCollectArticles(int id) {
        return mCollectApis.unCollectArticles(id);
    }

    @Override
    public Observable<BaseResponse<Collections>> getCollectionsData(int pageNum) {
        return mCollectApis.getCollectionsData(pageNum);
    }

    @Override
    public Observable<BaseResponse> unCollection(int id, int originId) {
        return mCollectApis.unCollection(id, originId);
    }

    @Override
    public Observable<BaseResponse<List<HotKey>>> getHotKey() {
        return mSearchApis.getHotKey();
    }

    @Override
    public Observable<BaseResponse<Articles>> getSearchArticles(String key, int pageNum) {
        return mSearchApis.getSearchArticles(key, pageNum);
    }

    @Override
    public Observable<Version> getVersionDetail() {
        return mVersionApi.getVersionDetail();
    }


}
