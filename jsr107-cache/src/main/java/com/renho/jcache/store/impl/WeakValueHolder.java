package com.renho.jcache.store.impl;

import com.renho.jcache.store.ValueHolder;

import java.lang.ref.WeakReference;

/**
 * @author zhangyongchao[sanmao]
 * 2018/3/5
 *
 * desc : 简单的弱引用实现
 **/
public class WeakValueHolder<V> implements ValueHolder<V> {


    private WeakReference<V> v;

    public WeakValueHolder(V value){
        /*
        * 使用JDK提供的WeakReference,简历对象的弱引用
        * 在没有强引用时，JVM GC将回收对象，调用WeakReference.get时 返回null*/
        this.v = new WeakReference<V>(value);
    }
    @Override
    public V value() {
        return this.v.get();
    }
}
