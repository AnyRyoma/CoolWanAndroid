package com.ryoma.coolwanandroid.event;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 登录成功事件
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class LoginEvent {
    private boolean isLogin;

    public LoginEvent(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public boolean isLogin() {
        return isLogin;
    }
}
