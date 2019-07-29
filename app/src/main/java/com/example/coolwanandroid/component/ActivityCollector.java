package com.example.coolwanandroid.component;

import android.app.Activity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 活动收集，一键退出app
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class ActivityCollector {
    private ActivityCollector() {
    }

    //DCL实现单例
    public static ActivityCollector getInstance() {
        return ActivityCollectorHolder.mActivityCollector;
    }

    private Set<Activity> allActivities;

    public void addActivity(Activity activity) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (allActivities != null) {
            allActivities.remove(activity);
        }
    }

    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity activity : allActivities) {
                    activity.finish();
                }
            }
        }
    }

    /**
     * 静态内部类单例模式
     */
    private static class ActivityCollectorHolder {
        private static final ActivityCollector mActivityCollector = new ActivityCollector();
    }
}
