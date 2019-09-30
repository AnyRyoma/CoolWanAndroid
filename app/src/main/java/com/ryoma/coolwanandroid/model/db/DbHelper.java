package com.ryoma.coolwanandroid.model.db;

import java.util.List;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 数据库操作接口
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface DbHelper {
    /**
     * 添加历史记录
     *
     * @param key 关键词
     * @return 是否有
     */
    boolean addHistory(String key);

    /**
     * 删除某一条历史记录
     *
     * @param key 关键词
     * @return 删除成功与否 返回值
     */
    int deleteOneHistory(String key);

    /**
     * 删除所有历史记录
     *
     * @return 返回值
     */
    int deleteAllHistory();

    /**
     * 查找某一条历史记录是否存在
     *
     * @param key 关键词
     * @return 是否存在
     */
    boolean isExistHistory(String key);

    /**
     * 获得所有历史记录
     */
    List<String> getAllHistory();
}
