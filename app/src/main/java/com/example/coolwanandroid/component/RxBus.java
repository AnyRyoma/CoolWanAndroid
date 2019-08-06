package com.example.coolwanandroid.component;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 订阅事件
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class RxBus {
    private final Subject<Object> mSubject;

    private RxBus() {
        mSubject = PublishSubject.create().toSerialized();
    }

    public static RxBus getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 发送一个事件
     */
    public void post(Object o) {
        mSubject.onNext(o);
    }

    /**
     * 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
     */
    public <T> Observable<T> toObservable(Class<T> eventType) {
        return mSubject.ofType(eventType);
    }

    /**
     * 静态内部类方式-单例模式
     */
    private static class Holder {
        static final RxBus INSTANCE = new RxBus();
    }
}
