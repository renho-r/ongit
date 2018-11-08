package com.renho.jcache.store.impl;

import com.renho.jcache.store.ValueHolder;

/**
 * @author zhangyongchao[sanmao]
 * 2018/3/5
 **/
public class BasicValueHolder<V> implements ValueHolder<V> {

    private final V refValue;

    public BasicValueHolder(final V value) {
        refValue = value;
    }

    public V value() {
        return refValue;
    }
}