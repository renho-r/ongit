package com.renho.springcloud.zuul.simple.controller;

import com.renho.springcloud.zuul.simple.locator.RouteDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: renho
 * @since: 1.0.0
 */
@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private RouteLocator routes;

    @Autowired
    ApplicationEventPublisher publisher;

    @RequestMapping("")
    public Map<String, String> getAll() {
        Map<String, String> map = new LinkedHashMap<>();
        for (Route route : this.routes.getRoutes()) {
            map.put(route.getFullPath(), route.getLocation());
        }
        return map;
    }

    @RequestMapping("/add")
    public Map<String, String> add() {
        ZuulProperties.ZuulRoute route = new ZuulProperties.ZuulRoute();
        route.setId("/api/test/**");
        route.setPath("/api/test/**");
        route.setServiceId("test-service");
        route.setStripPrefix(true);

        RouteDatabase.INSTANCE.put(route);
        RoutesRefreshedEvent routesRefreshedEvent = new RoutesRefreshedEvent(routes);
        publisher.publishEvent(routesRefreshedEvent);
        return this.getAll();
    }

    @RequestMapping("/add/simple")
    public Map<String, String> addSimple() {
        ZuulProperties.ZuulRoute route = new ZuulProperties.ZuulRoute();
        route.setId("/api/test/simple/**");
        route.setPath("/api/test/simple/**");
//        route.setLocation("http://localhost:9001/");
        route.setUrl("http://localhost:9001");
        route.setStripPrefix(true);

        RouteDatabase.INSTANCE.put(route);
        RoutesRefreshedEvent routesRefreshedEvent = new RoutesRefreshedEvent(routes);
        publisher.publishEvent(routesRefreshedEvent);
        return this.getAll();
    }

    @RequestMapping("/delete")
    public Map<String, String> delete() {
        ZuulProperties.ZuulRoute route = new ZuulProperties.ZuulRoute();
        route.setId("/api/test/**");
        route.setPath("/api/test/**");
        route.setServiceId("test-service");
        route.setStripPrefix(true);

        RouteDatabase.INSTANCE.remove(route);
        return this.getAll();
    }

}
