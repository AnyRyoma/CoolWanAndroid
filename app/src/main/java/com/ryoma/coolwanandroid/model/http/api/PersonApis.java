package com.ryoma.coolwanandroid.model.http.api;

import com.ryoma.coolwanandroid.model.entity.BaseResponse;
import com.ryoma.coolwanandroid.model.entity.Login;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @author eco-ryoma
 * @date 2019/01/26
 * @description 个人模块接口集合
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface PersonApis {
    /**
     * 登陆
     * http://www.wanandroid.com/user/login
     */
    @POST("user/login")
    @FormUrlEncoded
    Observable<BaseResponse<Login>> login(
            @Field("username") String userName,
            @Field("password") String password
    );


    /**
     * 注册
     * http://www.wanandroid.com/user/register
     */
    @POST("user/register")
    @FormUrlEncoded
    Observable<BaseResponse<Login>> register(@Field("username") String username,
                                             @Field("password") String password,
                                             @Field("repassword") String rePassword//确认密码
    );

    /**
     * 退出登陆
     * http://www.wanandroid.com/user/logout/json
     */
    @GET("user/logout/json")
    Observable<BaseResponse<Login>> logout();


}
