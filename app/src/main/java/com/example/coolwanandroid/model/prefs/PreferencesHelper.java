package com.example.coolwanandroid.model.prefs;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description SharedPreferences操作接口
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface PreferencesHelper {
    void setNightStyleState(boolean isNight); //保存夜间模式设置

    boolean getNightStyleState(); //得到夜间模式的设置

    void setNoImgState(boolean isNoImg);//保存无图模式设置

    boolean getNoImgStyleState();//得到无图模式的设置

    void setAutoCacheState(boolean isAutoCache);//保存自动缓存设置，自动缓存为文章详细的内容

    boolean getAutoCacheState(); //得到自动缓存设置

    void setDownloadId(long id);//保存更新apk的记录

    long getDownloadId();//得到下载记录

    void setNavCurrentItem(int position);//保存主活动的页面状态

    int getNavCurrentItem();//得到主活动的页面状态
}
