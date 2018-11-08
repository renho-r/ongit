package com.renho.jcache.store.impl;

import com.renho.jcache.store.DataStore;
import com.renho.jcache.store.StoreAccessException;
import com.renho.jcache.store.ValueHolder;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author zhangyongchao[sanmao]
 * 2018/3/5
 **/
public class LRUDataStore<K,V> implements DataStore<K,V> {

    //链表的最大存储量
    private int maxSize;

    //key LRUEntry
    private ConcurrentMap<K, LRUEntry<K, ValueHolder<?>>> map = new ConcurrentHashMap<K, LRUEntry<K, ValueHolder<?>>>();

    //维护LRU链表  双向链表实现的栈
    private LRUEntry<K, ValueHolder<?>> first;
    private LRUEntry<K, ValueHolder<?>> last;


    public LRUDataStore(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public ValueHolder<V> get(K key) throws StoreAccessException {
        LRUEntry<K, ValueHolder<?>> entry = getEntry(key);
        if (entry == null) {
            return null;
        }
        //将LRUEntry移动到首节点
        moveToFirst(entry);
        return (ValueHolder<V>) entry.getValue();
    }

    private void moveToFirst(LRUEntry<K, ValueHolder<?>> entry) {
        //entry为头结点
        if (entry == first) {
            return;
        }
        if (entry.getPre() != null) {
            entry.getPre().setNext(entry.getNext());
        }
        if (entry.getNext() != null) {
            entry.getNext().setPre(entry.getPre());
        }
        //判断entry是否为last节点
        if (last == entry) {
            last = entry.getPre();
        }

        //用于添加节点是判断  链表为空
        if (first == null || last == null) {
            first = last = entry;
            return;
        }

        //改变first
        entry.setNext(first);
        first.setPre(entry);
        first = entry;
        entry.setPre(null);
    }


    @Override
    public PutStatus put(K key, V value) throws StoreAccessException {

        LRUEntry<K, ValueHolder<?>> entry = getEntry(key);
        PutStatus putStatus = PutStatus.NOOP;
        if (entry == null) {
            //判断是否达到最大的缓存
            if (map.size() > maxSize) {
                map.remove(last.getKey());
                removeLast();

            }
            entry = new LRUEntry<K, ValueHolder<?>>(key, new BasicValueHolder<V>(value));
            putStatus = PutStatus.PUT;


        } else {
            entry.setValue(new BasicValueHolder<V>(value));
            putStatus = PutStatus.UPDATE;
        }
        moveToFirst(entry);
        map.put(key, entry);
        return putStatus;
    }

    @Override
    public ValueHolder<V> remove(K key) throws StoreAccessException {
        LRUEntry<K, ValueHolder<?>> entry = getEntry(key);
        //从LRU链表中删除
        if (entry != null) {
            if (entry.getPre() != null) {
                entry.getPre().setNext(entry.getNext());
            }
            if (entry.getNext() != null) {
                entry.getNext().setPre(entry.getPre());
            }
            //删除的是首节点
            if (entry == first) {
                first = entry.getNext();
            }
            //删除的是尾节点
            if (entry == last) {
                last = entry.getPre();
            }
        }
        //从map中删除
        LRUEntry<K, ValueHolder<?>> remove = map.remove(key);
        return (ValueHolder<V>) remove.getValue();
    }

    @Override
    public void clear() throws StoreAccessException {
        this.map.clear();
        first = last = null;
    }

    private LRUEntry<K, ValueHolder<?>> getEntry(K key) {
        return map.get(key);
    }

    private void removeLast() {
        if (last != null) {
            last = last.getPre();
            //只有一个节点
            if (last == null) {
                first = null;
            } else {
                last.next.pre = null;
                last.next = null;
            }
        }
    }
}
