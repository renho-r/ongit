package com.renho.zuul.server.dynamic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Autowired
    ZuulProperties zuulProperties;
    @Autowired
    ServerProperties server;

    @Bean
    public LogServerRouteLocator getRouteLocator() {
        return new LogServerRouteLocator(this.server.getServletPath(), this.zuulProperties);
    }

}
