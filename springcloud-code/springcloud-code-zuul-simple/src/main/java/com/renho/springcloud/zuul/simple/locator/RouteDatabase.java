package com.renho.springcloud.zuul.simple.locator;

import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: renho
 * @since: 1.0.0
 */
public enum RouteDatabase {

    INSTANCE;

    private ConcurrentHashMap<String, ZuulProperties.ZuulRoute> db = new ConcurrentHashMap();

    public ConcurrentHashMap routes() {
        return db;
    }

    public ZuulProperties.ZuulRoute put(ZuulProperties.ZuulRoute route) {
        return db.put(route.getPath(), route);
    }

}
