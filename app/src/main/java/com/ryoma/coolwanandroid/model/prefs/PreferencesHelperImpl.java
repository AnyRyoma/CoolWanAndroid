package com.ryoma.coolwanandroid.model.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.ryoma.coolwanandroid.app.App;
import com.ryoma.coolwanandroid.app.Constant;

import javax.inject.Inject;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description SharedPreferences操作实现累
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class PreferencesHelperImpl implements PreferencesHelper {
    private SharedPreferences mPreferences;

    @Inject
    public PreferencesHelperImpl() {
        mPreferences = App.getContext().getSharedPreferences(Constant.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void setNightStyleState(boolean isNight) {
        mPreferences.edit().putBoolean(Constant.KEY_PREFERS_NIGHT, isNight).apply();
    }

    @Override
    public boolean getNightStyleState() {
        return mPreferences.getBoolean(Constant.KEY_PREFERS_NIGHT, false);
    }

    @Override
    public void setNoImgState(boolean isNoImg) {
        mPreferences.edit().putBoolean(Constant.KEY_PREFERS_NO_IMG, isNoImg).apply();
    }

    @Override
    public boolean getNoImgStyleState() {
        return mPreferences.getBoolean(Constant.KEY_PREFERS_NO_IMG, false);
    }

    @Override
    public void setAutoCacheState(boolean isAutoCache) {
        mPreferences.edit().putBoolean(Constant.KEY_PREFERS_AUTO_CACHE, isAutoCache).apply();
    }

    @Override
    public boolean getAutoCacheState() {
        return mPreferences.getBoolean(Constant.KEY_PREFERS_AUTO_CACHE, true);
    }

    @Override
    public void setDownloadId(long id) {
        mPreferences.edit().putLong(Constant.KEY_PREFERS_DOWNLOAD_ID, id).apply();
    }

    @Override
    public long getDownloadId() {
        return mPreferences.getLong(Constant.KEY_PREFERS_DOWNLOAD_ID, -1L);
    }

    @Override
    public void setNavCurrentItem(int position) {
        mPreferences.edit().putInt(Constant.KEY_PREFERS_NAV_ITEM, position).apply();
    }

    @Override
    public int getNavCurrentItem() {
        return mPreferences.getInt(Constant.KEY_PREFERS_NAV_ITEM, 0);
    }
}
