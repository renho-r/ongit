package com.renho.jcache;

import com.renho.jcache.store.DataStore;
import com.renho.jcache.store.StoreAccessException;
import com.renho.jcache.store.ValueHolder;

/**
 * @author zhangyongchao[sanmao]
 * 2018/3/5
 * des: 直接使用CsCache的时候,接口类
 **/

//https://github.com/a1525155750/CsCache.git
public class JCache<K,V> {

    private DataStore<K,V> dataStore;

    public JCache(DataStore<K, V> dataStore) {
        this.dataStore = dataStore;
    }


    public V get(K key) {
        ValueHolder<V> holder = null;
        try {
            holder = dataStore.get(key);
        } catch (StoreAccessException e) {
            e.printStackTrace();
        }
        return holder.value();
    }

    public DataStore.PutStatus put(K key, V value) {
        DataStore.PutStatus putStatus = null;
        try {
            putStatus = dataStore.put(key, value);
        } catch (StoreAccessException e) {
            e.printStackTrace();
        }
        return putStatus;
    }

    public ValueHolder<V> remove(K key) throws StoreAccessException{
        ValueHolder<V> remove = dataStore.remove(key);
        return remove;
    }

    public void clear() throws StoreAccessException{
        dataStore.clear();
    }
}
