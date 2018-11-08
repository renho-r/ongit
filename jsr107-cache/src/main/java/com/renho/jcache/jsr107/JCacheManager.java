package com.renho.jcache.jsr107;

import javax.cache.Cache;
import javax.cache.CacheException;
import javax.cache.CacheManager;
import javax.cache.configuration.Configuration;
import javax.cache.spi.CachingProvider;
import java.net.URI;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class JCacheManager implements CacheManager {

    private final JCachingProvider cachingProvider;
    private final ClassLoader classLoader;
    private final URI uri;
    private final Properties props;

    /**
     * 存储缓存的实例  可进行并发的对caches的读写
     */
    private final ConcurrentMap<String, JCache107<?, ?>> caches = new ConcurrentHashMap<>();

    public JCacheManager(JCachingProvider cachingProvider, ClassLoader classLoader, URI uri, Properties props) {
        this.cachingProvider = cachingProvider;
        this.classLoader = classLoader;
        this.uri = uri;
        this.props = props;
    }

    @Override
    public CachingProvider getCachingProvider() {
        return null;
    }

    @Override
    public URI getURI() {
        return null;
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public <K, V, C extends Configuration<K, V>> Cache<K, V> createCache(String cacheName, C configuration) throws IllegalArgumentException {
        if (isClosed()) {
            throw new IllegalStateException();
        }
        checkNotNull(cacheName, "cacheName");
        checkNotNull(configuration, "configuration");
        //根据cacheName获取客户端缓存实例
        JCache107<?, ?> cache = caches.get(cacheName);
        if (null == cache) {
            synchronized (caches) {
                cache = caches.get(cacheName);
                if (null == cache) {
                    cache = new JCache107<K, V>(cacheName, this, configuration);
                    caches.put(cache.getName(), cache);
                }
            }
            return (Cache<K, V>) cache;
        } else {
            throw new CacheException(cacheName + " already exists");
        }
    }

    @Override
    public <K, V> Cache<K, V> getCache(String s, Class<K> aClass, Class<V> aClass1) {
        return null;
    }

    @Override
    public <K, V> Cache<K, V> getCache(String s) {
        return null;
    }

    @Override
    public Iterable<String> getCacheNames() {
        return null;
    }

    @Override
    public void destroyCache(String s) {

    }

    @Override
    public void enableManagement(String s, boolean b) {

    }

    @Override
    public void enableStatistics(String s, boolean b) {

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

    private void checkNotNull(Object object, String name) {
        if (object == null) {
            throw new NullPointerException(name + " can not be null");
        }
    }
}
