package com.renho.jcache.store;

/**
 * @author zhangyongchao[sanmao]
 * 2018/3/5
 *
 *  dec: 存储数据的规范定义
 **/
public interface DataStore<K,V> {
    ValueHolder<V> get(K key) throws StoreAccessException;
    PutStatus put(K key,V value)throws StoreAccessException;
    ValueHolder<V> remove(K key) throws StoreAccessException;
    void clear() throws StoreAccessException;

    enum PutStatus{
        //put new value
        PUT,
        //replace old value
        UPDATE,
        //
        NOOP
    }


}
