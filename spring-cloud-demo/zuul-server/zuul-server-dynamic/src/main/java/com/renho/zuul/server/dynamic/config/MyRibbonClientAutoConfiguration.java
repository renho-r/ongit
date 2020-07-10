package com.renho.zuul.server.dynamic.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Configuration
@RibbonClients(defaultConfiguration = RibbonDefaultClientConfig.class)
@AutoConfigureBefore(name = "org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration")
public class MyRibbonClientAutoConfiguration {
}
