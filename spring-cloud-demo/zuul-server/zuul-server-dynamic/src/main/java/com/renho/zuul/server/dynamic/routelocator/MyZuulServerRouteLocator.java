package com.renho.zuul.server.dynamic.routelocator;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;

/**
 * @author renho
 */
public class MyZuulServerRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

    public MyZuulServerRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);

    }

    @Override
    public void refresh() {
        doRefresh();
    }

    //覆盖这个方法，从重实现它
    @Override
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {

        //重新定义一个路由映射map
        LinkedHashMap<String, ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap<>();
        //把父类中的映射继承下来，它主要是从配置文件中取的映射。
        routesMap.putAll(super.locateRoutes());

        //这里的路由信息来自于配置文件
        String path = "/api/user/**";
        ZuulRoute zr = new ZuulRoute();
        //服务提供者的id,即spring.application.name
        zr.setServiceId("USER-SERVICE");
        //这个id是匹配的前半部分，比如匹配模式是/node/** 那么这个id就是/node ??????
        zr.setId("user");
        //匹配的路径
        zr.setPath(path);
        zr.setStripPrefix(false);
        routesMap.put(path, zr);

        path = "/api/product/**";
        zr = new ZuulRoute();
        zr.setServiceId("PRODUCT-SERVICE");
        zr.setId("product");
        zr.setPath(path);
//        zr.setUrl("http://127.0.0.1:8773");
        zr.setStripPrefix(false);
        routesMap.put(path, zr);

        return routesMap;
    }

}
