package com.renho.zuul.server.dynamic;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;

public class LogServerRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

//    @Autowired
//    private ServerConfigService serverConfigService;

    public LogServerRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);

    }

    @Override
    public void refresh() {
        doRefresh();
    }
    //覆盖这个方法，从重实现它
    @Override
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {

        Map<String, String> nodes = new HashMap<>();

        //重新定义一个路由映射map
        LinkedHashMap<String, ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap<>();
        //把父类中的映射继承下来，它主要是从配置文件中取的映射。
        routesMap.putAll(super.locateRoutes());
        //这里的路由信息来自于配置文件
//        for (Map.Entry<String, String> entry: nodes.entrySet()) {

            String path = "/api/user/**";
            ZuulRoute zr = new ZuulRoute();
            zr.setServiceId("USER-SERVICE");
            zr.setId("renho");
            zr.setPath(path);
            routesMap.put(path, zr);

            zr.setStripPrefix(true);

//            String serverId = entry.getKey();
//            String serviceId = entry.getValue().toLowerCase();
//            String path = "/node/**";
//            ZuulRoute zuulRoute = new ZuulRoute();
//            //服务提供者的id,即spring.application.name
//            zuulRoute.setServiceId(serviceId);
//            //这个id是匹配的前半部分，比如匹配模式是/node/** 那么这个id就是/node
//            zuulRoute.setId("/node");
//            //匹配的路径
//            zuulRoute.setPath(path);
//            //这里注意一下，这个key就是要匹配的path,可以查看父类的实现，它就是使用path做为key的。
//            routesMap.put(path, zuulRoute);
//        }
        return routesMap;
    }

}
