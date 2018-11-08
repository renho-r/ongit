package com.renho.jcache.jsr107;

import com.renho.jcache.JCache;
import com.renho.jcache.store.impl.LRUDataStore;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.configuration.CacheEntryListenerConfiguration;
import javax.cache.configuration.Configuration;
import javax.cache.integration.CompletionListener;
import javax.cache.processor.EntryProcessor;
import javax.cache.processor.EntryProcessorException;
import javax.cache.processor.EntryProcessorResult;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class JCache107<K, V> implements Cache<K, V> {

    private final String cacheName;
    private final JCacheManager cachingManager;
    private final Configuration<K, V> configuration;
    private volatile boolean isClosed;
    private JCache<K, V> cache = new JCache<K, V>(new LRUDataStore<K, V>(2));

    public JCache107(String cacheName, JCacheManager cachingManager, Configuration<K, V> configuration) {
        this.cacheName = cacheName;
        this.cachingManager = cachingManager;
        this.configuration = configuration;
        isClosed = false;
    }

    @Override
    public V get(K k) {
        return cache.get(k);
    }

    @Override
    public Map<K, V> getAll(Set<? extends K> set) {
        return null;
    }

    @Override
    public boolean containsKey(K k) {
        return false;
    }

    @Override
    public void loadAll(Set<? extends K> set, boolean b, CompletionListener completionListener) {

    }

    @Override
    public void put(K k, V v) {
        cache.put(k, v);
    }

    @Override
    public V getAndPut(K k, V v) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {

    }

    @Override
    public boolean putIfAbsent(K k, V v) {
        return false;
    }

    @Override
    public boolean remove(K k) {
        return false;
    }

    @Override
    public boolean remove(K k, V v) {
        return false;
    }

    @Override
    public V getAndRemove(K k) {
        return null;
    }

    @Override
    public boolean replace(K k, V v, V v1) {
        return false;
    }

    @Override
    public boolean replace(K k, V v) {
        return false;
    }

    @Override
    public V getAndReplace(K k, V v) {
        return null;
    }

    @Override
    public void removeAll(Set<? extends K> set) {

    }

    @Override
    public void removeAll() {

    }

    @Override
    public void clear() {

    }

    @Override
    public <C extends Configuration<K, V>> C getConfiguration(Class<C> aClass) {
        return null;
    }

    @Override
    public <T> T invoke(K k, EntryProcessor<K, V, T> entryProcessor, Object... objects) throws EntryProcessorException {
        return null;
    }

    @Override
    public <T> Map<K, EntryProcessorResult<T>> invokeAll(Set<? extends K> set, EntryProcessor<K, V, T> entryProcessor, Object... objects) {
        return null;
    }

    @Override
    public String getName() {
        return cacheName;
    }

    @Override
    public CacheManager getCacheManager() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public boolean isClosed() {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> aClass) {
        return null;
    }

    @Override
    public void registerCacheEntryListener(CacheEntryListenerConfiguration<K, V> cacheEntryListenerConfiguration) {

    }

    @Override
    public void deregisterCacheEntryListener(CacheEntryListenerConfiguration<K, V> cacheEntryListenerConfiguration) {

    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return null;
    }
}
