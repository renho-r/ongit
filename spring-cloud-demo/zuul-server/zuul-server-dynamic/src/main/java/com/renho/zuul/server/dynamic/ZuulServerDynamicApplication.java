package com.renho.zuul.server.dynamic;

import com.renho.zuul.server.dynamic.config.ExcludeComponent;
import com.renho.zuul.server.dynamic.config.ProductServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author renho
 */
@EnableZuulProxy
@SpringBootApplication
//@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeComponent.class) })
@RibbonClients(value = {
//        @RibbonClient(name = "client", configuration = RibbonClientConfiguration.class),
        @RibbonClient(name = "product-service", configuration = ProductServiceConfiguration.class)
})
//@RibbonClient(name = "product-service", configuration = ProductServiceConfiguration.class)
public class ZuulServerDynamicApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerDynamicApplication.class, args);
    }

}
