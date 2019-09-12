package com.ryoma.coolwanandroid.model.http.exception;

/**
 * @author eco-ryoma
 * @date 2019/01/21
 * @description 自定义api异常
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class ApiException extends Exception {
    private final int mErrorCode;
    private final String mErrorMessage;

    public ApiException(int errorCode, String errorMessage) {
        this.mErrorCode = errorCode;
        this.mErrorMessage = errorMessage;
    }

    public int getErrorCode() {
        return mErrorCode;
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }
}
