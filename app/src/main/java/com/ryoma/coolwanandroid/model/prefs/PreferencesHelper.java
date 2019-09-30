package com.ryoma.coolwanandroid.model.prefs;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description SharedPreferences操作接口
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface PreferencesHelper {
    /**
     * 保存夜间模式设置
     *
     * @param isNight 是否设置夜间模式
     */
    void setNightStyleState(boolean isNight);

    /**
     * 得到夜间模式的设置
     *
     * @return 模式设置
     */
    boolean getNightStyleState();

    /**
     * 保存无图模式设置
     *
     * @param isNoImg 是否无图模式
     */
    void setNoImgState(boolean isNoImg);

    /**
     * 得到无图模式的设置
     *
     * @return 无图模式
     */
    boolean getNoImgStyleState();

    /**
     * 保存自动缓存设置，自动缓存为文章详细的内容
     *
     * @param isAutoCache 自动缓存与否
     */
    void setAutoCacheState(boolean isAutoCache);

    /**
     * 得到自动缓存设置
     *
     * @return 自动缓存
     */
    boolean getAutoCacheState();

    /**
     * 保存更新apk的记录
     *
     * @param id 任务id
     */
    void setDownloadId(long id);

    /**
     * 得到下载记录
     *
     * @return 任务id
     */
    long getDownloadId();

    /**
     * 保存主活动的页面状态
     *
     * @param position 设置导航页当前position
     */
    void setNavCurrentItem(int position);

    /**
     * 得到主活动的页面状态
     *
     * @return 导航页当前item
     */
    int getNavCurrentItem();
}
