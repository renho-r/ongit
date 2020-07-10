package com.renho.springcloud.zuul.simple.config;

import com.renho.springcloud.zuul.simple.locator.MyRouteLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Configuration
public class ZuulConfig {

    @Autowired
    private ZuulProperties zuulProperties;

    @Autowired
    private ServerProperties server;

    @Bean
    public RouteLocator myRouteLocator() {
        MyRouteLocator routeLocator = new MyRouteLocator(this.server.getServlet().getContextPath(), this.zuulProperties);
        routeLocator.setOrder(Integer.MAX_VALUE);
        return routeLocator;
    }

}
