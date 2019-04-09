package com.renho.zuul.server.dynamic.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用RibbonClient，为特定name的Ribbon Client自定义配置.
 * 使用@RibbonClient的configuration属性，指定Ribbon的配置类.
 * 可参考的示例：
 * http://spring.io/guides/gs/client-side-load-balancing/
 * @author renho
 */
@Configuration
public class ProductServiceConfiguration {

    @Bean
    public IRule ribbonRule() {
        // 负载均衡规则，改为随机
        IRule rule = new RandomRule();
        rule.getLoadBalancer();
        return rule;
    }

//    @Bean
//    public ServerList<Server> ribbonServerListP() {
//
//        Server server = new Server("127.0.0.1", 8773);
//        server.setAlive(true);
//
//        StaticServerList<Server> serverList = new StaticServerList(server);
//        return serverList;
//    }


}