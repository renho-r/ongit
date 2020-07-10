package com.renho.zuul.server.dynamic.config;

import com.netflix.client.RetryHandler;
import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.discovery.EurekaClient;
import com.netflix.loadbalancer.*;
import com.netflix.niws.loadbalancer.DiscoveryEnabledNIWSServerList;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.ribbon.*;
import org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Provider;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Configuration
@EnableConfigurationProperties
@ExcludeComponent
public class RibbonDefaultClientConfig/* implements BeanFactoryPostProcessor*/ {

    public static final int DEFAULT_CONNECT_TIMEOUT = 1000;
    public static final int DEFAULT_READ_TIMEOUT = 1000;

    @Value("${ribbon.client.name}")
    private String name = "client";
    @Value("${ribbon.eureka.approximateZoneFromHostname:false}")
    private boolean approximateZoneFromHostname = false;

    @Autowired
    private PropertiesFactory propertiesFactory;

    @Bean
    public IClientConfig ribbonClientConfig() {
        DefaultClientConfigImpl config = new DefaultClientConfigImpl();
        config.loadProperties(this.name);
        config.set(CommonClientConfigKey.ConnectTimeout, DEFAULT_CONNECT_TIMEOUT);
        config.set(CommonClientConfigKey.ReadTimeout, DEFAULT_READ_TIMEOUT);
        return config;
    }

    @Bean
    public IRule ribbonRule(IClientConfig config) {
        if("PRODUCT-SERVICE".equals(this.name)) {
            return new BestAvailableRule();
        } else {
            if (this.propertiesFactory.isSet(IRule.class, name)) {
                return this.propertiesFactory.get(IRule.class, config, name);
            }
            ZoneAvoidanceRule rule = new ZoneAvoidanceRule();
            rule.initWithNiwsConfig(config);
            return rule;
        }
    }

    @Bean
    public IPing ribbonPing(IClientConfig config) {
        if("PRODUCT-SERVICE".equals(this.name)) {
            return new PingUrl();
        } else {
            if (this.propertiesFactory.isSet(IPing.class, name)) {
                return this.propertiesFactory.get(IPing.class, config, name);
            }
            return new DummyPing();
        }
    }

//    @Bean
    public ServerList<Server> ribbonServerList(IClientConfig config) {

        if("PRODUCT-SERVICE".equals(this.name)) {
            Server server = new Server("127.0.0.1", 8773);
            server.setAlive(true);

            Server server1 = new Server("127.0.0.1", 8775);
            server1.setAlive(true);

            StaticServerList<Server> serverList = new StaticServerList(server, server1);
            return serverList;
        } else if("USER-SERVICE".equals(name)) {
            return null;
        } else {
            if (this.propertiesFactory.isSet(ServerList.class, name)) {
                return this.propertiesFactory.get(ServerList.class, config, name);
            }
            ConfigurationBasedServerList serverList = new ConfigurationBasedServerList();
            serverList.initWithNiwsConfig(config);
            return serverList;
        }
    }

    @Bean
    public ServerList<?> ribbonServerList(IClientConfig config, Provider<EurekaClient> eurekaClientProvider) {

        if("PRODUCT-SERVICE".equals(this.name)) {
            Server server = new Server("127.0.0.1", 8773);
            server.setAlive(true);

//            Server server1 = new Server("127.0.0.1", 8775);
//            server1.setAlive(true);

            StaticServerList<Server> serverList = new StaticServerList(server);
            return serverList;
        } else if("USER-SERVICE".equals(name) || "ZUUL-SERVICE".equals(name)) {
            if (this.propertiesFactory.isSet(ServerList.class, name)) {
                return this.propertiesFactory.get(ServerList.class, config, name);
            }
            DiscoveryEnabledNIWSServerList discoveryServerList = new DiscoveryEnabledNIWSServerList(config, eurekaClientProvider);
            DomainExtractingServerList serverList = new DomainExtractingServerList(discoveryServerList, config, this.approximateZoneFromHostname);
            return serverList;
        } else {
            if (this.propertiesFactory.isSet(ServerList.class, name)) {
                return this.propertiesFactory.get(ServerList.class, config, name);
            }
            ConfigurationBasedServerList serverList = new ConfigurationBasedServerList();
            serverList.initWithNiwsConfig(config);
            return serverList;
        }
    }

    @Bean
    public ServerListUpdater ribbonServerListUpdater(IClientConfig config) {
        return new PollingServerListUpdater(config);
    }

    @Bean
    public ILoadBalancer ribbonLoadBalancer(IClientConfig config,
                                            ServerList<Server> serverList, ServerListFilter<Server> serverListFilter,
                                            IRule rule, IPing ping, ServerListUpdater serverListUpdater) {
        if (this.propertiesFactory.isSet(ILoadBalancer.class, name)) {
            return this.propertiesFactory.get(ILoadBalancer.class, config, name);
        }
        return new ZoneAwareLoadBalancer<>(config, rule, ping, serverList,
                serverListFilter, serverListUpdater);
    }

    @Bean
    public ServerListFilter<Server> ribbonServerListFilter(IClientConfig config) {

        if("PRODUCT-SERVICE".equals(this.name)) {
            return new ServerListSubsetFilter();
        } else {
            if (this.propertiesFactory.isSet(ServerListFilter.class, name)) {
                return this.propertiesFactory.get(ServerListFilter.class, config, name);
            }
            ZonePreferenceServerListFilter filter = new ZonePreferenceServerListFilter();
            filter.initWithNiwsConfig(config);
            return filter;
        }
    }

    private ConfigurableListableBeanFactory beanFactory;

//    @Override
//    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        this.beanFactory = beanFactory;
//        ((DefaultListableBeanFactory) this.beanFactory).removeBeanDefinition("ribbonRule");
//    }
}
