package com.renho.springcloud.zuul.simple.locator;

import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

import java.util.Map;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class MyRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

    public MyRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
    }

    @Override
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {
        return RouteDatabase.INSTANCE.routes();
    }

    @Override
    public void refresh() {
        super.doRefresh();
    }
}
