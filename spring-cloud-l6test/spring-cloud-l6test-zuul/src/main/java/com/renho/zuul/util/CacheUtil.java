package com.renho.zuul.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: renho
 * @since: 1.0.0
 */
public enum CacheUtil {

    INSTANCE;

    private Map<String, Object> cache = new HashMap<>();

    public Object getToken(String id) {
        return cache.get(id);
    }

    public void setCache(String id, Object token) {
        cache.put(id, token);
    }
}
