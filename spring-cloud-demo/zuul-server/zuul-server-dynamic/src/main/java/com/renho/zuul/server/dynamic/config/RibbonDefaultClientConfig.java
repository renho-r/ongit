package com.renho.zuul.server.dynamic.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Configuration
@EnableConfigurationProperties
public class RibbonDefaultClientConfig {

    @Value("${ribbon.client.name:default}")
    private String name = "client";

    @Bean
    public IRule ribbonRule() {
        return new BestAvailableRule();
    }

    @Bean
    public IPing ribbonPing() {
        return new PingUrl();
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

    @Bean
    public ServerListSubsetFilter serverListFilter() {
        ServerListSubsetFilter filter = new ServerListSubsetFilter();
        return filter;
    }

}
