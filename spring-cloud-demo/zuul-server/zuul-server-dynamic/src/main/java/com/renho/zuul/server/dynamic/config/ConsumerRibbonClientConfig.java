package com.renho.zuul.server.dynamic.config;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.cloud.netflix.ribbon.ZonePreferenceServerListFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;

//自定义ribbon策略可以覆盖RibbonClientConfiguration中的默认配置。
//RibbonClientConfiguration每个方法都可以被覆盖
//自定义的Ribbon配置不能放在SpringApplication的同级或下级目录中会覆盖所有的Ribbon客户端配置,所有的客户端都使用了相同的配置。
//自定义的Ribbon配置不能放在ComponentScan的目录中否则次配置会覆盖所有的Ribbon客户端配置,所有的客户端都使用了相同的配置。
@Configuration
@ExcludeComponent
public class ConsumerRibbonClientConfig {

    public static final int DEFAULT_CONNECT_TIMEOUT = 1000;
    public static final int DEFAULT_READ_TIMEOUT = 1000;

    @Bean
    public IRule ribbonRule(IClientConfig config) {

        //轮询策略
//        ZoneAvoidanceRule rule = new ZoneAvoidanceRule();
//        rule.initWithNiwsConfig(config);

        IRule rule = new RandomRule();
        rule.getLoadBalancer();
        return rule;
    }

    // 检测服务是否存活
    @Bean
    public IPing ribbonPing(IClientConfig config) {
        return new DummyPing();
    }

    /* 服务列保, 覆盖此方法,必须在yml/properties文件中配置服务列表
    @Bean
    public ServerList<Server> ribbonServerList(IClientConfig config) {
        ConfigurationBasedServerList serverList = new ConfigurationBasedServerList();
        serverList.initWithNiwsConfig(config);
        return serverList;
    }
    */

    //服务列表更新器
    @Bean
    public ServerListUpdater ribbonServerListUpdater(IClientConfig config) {
        return new PollingServerListUpdater(config);
    }

    //负载均衡器
    @Bean
    public ILoadBalancer ribbonLoadBalancer(IClientConfig config,
                                            ServerList<Server> serverList, ServerListFilter<Server> serverListFilter,
                                            IRule rule, IPing ping, ServerListUpdater serverListUpdater) {
        return new ZoneAwareLoadBalancer<>(config, rule, ping, serverList,
                serverListFilter, serverListUpdater);
    }


    //此接口允许过滤配置或动态获得的具有良好特性的候选服务器列表。
    @Bean
    public ServerListFilter<Server> ribbonServerListFilter(IClientConfig config) {
        ZonePreferenceServerListFilter filter = new ZonePreferenceServerListFilter();
        filter.initWithNiwsConfig(config);
        return filter;
    }

    @Bean
    public ServerList<Server> ribbonServerList() {

        Server server = new Server("127.0.0.1", 8773);
        server.setAlive(true);

        Server server1 = new Server("127.0.0.1", 8775);
        server1.setAlive(true);

        StaticServerList<Server> serverList = new StaticServerList(server, server1);
        return serverList;
    }
}
