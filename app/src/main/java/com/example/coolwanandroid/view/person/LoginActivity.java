package com.example.coolwanandroid.view.person;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.coolwanandroid.R;
import com.example.coolwanandroid.utils.KeyBoardUtil;
import com.example.coolwanandroid.utils.StatusBarUtil;
import com.github.glomadrian.grav.GravView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author eco-ryoma
 * @date 2019/01/21
 * @description 登录页
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.backBtn)
    Button backBtn;
    @BindView(R.id.grav)
    GravView grav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        StatusBarUtil.immersiveInImage(this);
        replaceFragment(LoginFragment.newInstance());
        backBtn.setOnClickListener(v -> finish());
    }

    /**
     * 移除注册界面
     */
    public void toRegisterFragment() {
        replaceFragment(RegisterFragment.newInstance());
    }

    /**
     * 切换登录和注册
     *
     * @param fragment
     */
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameContain, fragment);
        if (fragment instanceof RegisterFragment)
            transaction.addToBackStack(null);
        transaction.commit();
    }

    public static void startActivityForResultByFragment(Activity activity, Fragment fragment, int request) {
        Intent intent = new Intent(activity, LoginActivity.class);
        fragment.startActivityForResult(intent, request);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //防止Grav出现内存泄漏
        if (grav != null) {
            grav.stop();
        }
        KeyBoardUtil.fixInputMethodManagerLeak(this);//修复输入法引起的内存泄漏
    }
}
