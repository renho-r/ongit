package com.renho.springcloud.zuul.simple.config;

import com.renho.springcloud.zuul.simple.test.MapObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Configuration
public class RenhoAutoConfig {

    @Autowired
    private Map<String, MapObject> mapObjects;

    @Autowired
    private List<RouteLocator> routeLocators;

    @Bean
    public MapObject mapObject1() {
        return new MapObject();
    }

    @Bean
    public MapObject mapObject2() {
        return new MapObject();
    }

    @Bean
    public ApplicationListener myRefreshListener() {
        return new MyRefreshListener();
    }

    @PostConstruct
    public void init() {
        System.out.printf("\n");
    }
}
