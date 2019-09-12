package com.ryoma.coolwanandroid.model.entity;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 网络请求返回的基本类
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class BaseResponse<T> {
    /**
     * data : []
     * errorCode : 0代表执行成功，非0都为失败 -1001 代表登录失效，需要重新登录。
     * errorMsg :
     */
    private int errorCode;
    private String errorMsg;
    private T data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
