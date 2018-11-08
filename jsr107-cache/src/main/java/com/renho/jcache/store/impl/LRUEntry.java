package com.renho.jcache.store.impl;

import com.renho.jcache.store.ValueHolder;

import java.util.Map;

/**
 * @author zhangyongchao[sanmao]
 * 2018/3/5
 **/
public class LRUEntry<K, V extends ValueHolder<?>> implements Map.Entry<K, ValueHolder<?>> {
    private final K key;
    private ValueHolder<?> v;

    LRUEntry<K, ValueHolder<?>> pre;
    LRUEntry<K, ValueHolder<?>> next;

    public LRUEntry(K key, ValueHolder<?> v) {
        this.key = key;
        this.v = v;
    }

    public LRUEntry<K, ValueHolder<?>> getPre() {
        return pre;
    }

    public void setPre(LRUEntry<K, ValueHolder<?>> pre) {
        this.pre = pre;
    }

    public LRUEntry<K, ValueHolder<?>> getNext() {
        return next;
    }

    public void setNext(LRUEntry<K, ValueHolder<?>> next) {
        this.next = next;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public ValueHolder<?> getValue() {
        return v;
    }

    @Override
    public ValueHolder<?> setValue(ValueHolder<?> value) {
        ValueHolder<?> oldValue = this.v;
        this.v = value;
        return oldValue;
    }
}
