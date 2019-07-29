package com.example.coolwanandroid.utils;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.coolwanandroid.R;
import com.example.coolwanandroid.app.App;
import com.example.coolwanandroid.app.Constant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 一些公有的工具
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class CommonUtils {

    public static void toastShow(String msg){
        Toast.makeText(App.getContext(),msg,Toast.LENGTH_SHORT).show();
    }
    public static boolean isEmptyList(List<?> list) {
        return list == null || list.size() == 0;
    }


    public static void collectAnimator(Context context, View view){
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.collect_anim);
        animatorSet.setTarget(view);
        animatorSet.start();
    }

    /**
     * 获取随机rgb颜色值
     */
    public static int randomColor() {
        Random random = new Random();
        //0-190, 如果颜色值过大,就越接近白色,就看不清了,所以需要限定范围
        int red =random.nextInt(150);
        //0-190
        int green =random.nextInt(150);
        //0-190
        int blue =random.nextInt(150);
        //使用rgb混合生成一种新的颜色,Color.rgb生成的是一个int数
        return Color.rgb(red,green, blue);
    }

    public static int randomTagColor() {
        int randomNum = new Random().nextInt();
        int position = randomNum % Constant.TAB_COLORS.length;
        if (position < 0) {
            position = -position;
        }
        return Constant.TAB_COLORS[position];
    }

    /**
     * 检查是否有可用网络
     */
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }

    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    public static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }
}
