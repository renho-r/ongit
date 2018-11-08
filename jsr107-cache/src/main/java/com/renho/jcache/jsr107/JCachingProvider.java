package com.renho.jcache.jsr107;

import javax.cache.CacheException;
import javax.cache.CacheManager;
import javax.cache.configuration.OptionalFeature;
import javax.cache.spi.CachingProvider;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Properties;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class JCachingProvider implements CachingProvider {

    /**
     *
     */
    private static final String DEFAULT_URI_STRING = "urn:X-cscache:jsr107-default-config";
    private static final URI URI_DEFAULT;
    private final Map<ClassLoader, ConcurrentMap<URI, CacheManager>> cacheManagers = new WeakHashMap<>();

    static {
        try {
            URI_DEFAULT = new URI(DEFAULT_URI_STRING);
        } catch (URISyntaxException e) {
            throw new CacheException(e);
        }
    }

    @Override
    public CacheManager getCacheManager(URI uri, ClassLoader classLoader, Properties properties) {
        uri = null == uri ? getDefaultURI() : uri;
        classLoader = null == classLoader ? getDefaultClassLoader() : classLoader;
        properties = null == properties ? new Properties() : cloneProperties(properties);

        ConcurrentMap<URI, CacheManager> cacheManagersByURI = cacheManagers.get(classLoader);

        if (null == cacheManagersByURI) {
            cacheManagersByURI = new ConcurrentHashMap<>();
        }

        CacheManager cacheManager = cacheManagersByURI.get(uri);

        if (null == cacheManager) {
            cacheManager = new JCacheManager(this, classLoader, uri, properties);
            cacheManagersByURI.put(uri, cacheManager);
        }

        if (!cacheManagers.containsKey(classLoader)) {
            cacheManagers.put(classLoader, cacheManagersByURI);
        }
        return cacheManager;
    }

    @Override
    public ClassLoader getDefaultClassLoader() {
        return getClass().getClassLoader();
    }

    @Override
    public URI getDefaultURI() {
        return URI_DEFAULT;
    }

    @Override
    public Properties getDefaultProperties() {
        return new Properties();
    }

    @Override
    public CacheManager getCacheManager(URI uri, ClassLoader classLoader) {
        return getCacheManager(uri, classLoader, getDefaultProperties());
    }

    @Override
    public CacheManager getCacheManager() {
        return getCacheManager(getDefaultURI(), getDefaultClassLoader(), null);
    }

    @Override
    public void close() {

    }

    @Override
    public void close(ClassLoader classLoader) {

    }

    @Override
    public void close(URI uri, ClassLoader classLoader) {

    }

    @Override
    public boolean isSupported(OptionalFeature optionalFeature) {
        return false;
    }
    private static Properties cloneProperties(Properties properties) {
        Properties clone = new Properties();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            clone.put(entry.getKey(), entry.getValue());
        }
        return clone;
    }

}
