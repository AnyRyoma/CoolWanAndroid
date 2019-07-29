package com.example.coolwanandroid.app;

import com.example.coolwanandroid.utils.FileUtil;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author eco-ryoma
 * @date 2019/01/26
 * @description 对象持久化
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class User implements Serializable, Cloneable {
    private final static String TAG = "User";
    private static final long serialVersionUID = 1L;
    private static User instance;

    private User() {
    }

    private String mUsername;//用户名
    private String mPassword;//密码
    private boolean mLoginStatus;//登陆状态

    /**
     * 退出登录时使用
     */
    public void reset() {
        mUsername = null;
        mPassword = null;
        mLoginStatus = false;
        save();
    }

    public void save() {
        FileUtil.saveObject(App.getContext(), TAG, this);
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public boolean isLoginStatus() {
        return mLoginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        mLoginStatus = loginStatus;
    }

    // -----------以下方法防止反序列化时重新生成对象-----------------
    public User readResolve() throws ObjectStreamException, CloneNotSupportedException {
        instance = (User) this.clone();
        return instance;
    }

    private void readObject(ObjectInputStream os) throws IOException, ClassNotFoundException {
        os.defaultReadObject();
    }

    public Object Clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 单例模式
     *
     * @return User
     */
    public static User getInstance() {
        if (instance == null) {
            synchronized (User.class) {
                if (instance == null) {
                    Object object = FileUtil.restoreObject(App.getContext(), TAG);
                    // App第一次启动，文件不存在，则新建之
                    if (object == null) {
                        object = new User();
                        FileUtil.saveObject(App.getContext(), TAG, object);
                    }
                    instance = (User) object;
                }
            }
        }
        return instance;
    }

}
