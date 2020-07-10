package com.renho.zuul.server.dynamic;

import com.renho.zuul.server.dynamic.config.ConsumerRibbonClientConfig;
import com.renho.zuul.server.dynamic.config.ExcludeComponent;
//import com.renho.zuul.server.dynamic.config.RibbonDefaultClientConfig;
import com.renho.zuul.server.dynamic.config.RibbonDefaultClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * @author renho
 */
@EnableZuulProxy
@SpringBootApplication
@RibbonClients(
        //配置defaultConfiguration会报空指针异常，有知道的同学麻烦告诉下
        defaultConfiguration = RibbonDefaultClientConfig.class,
        value= {
//                @RibbonClient(name="PRODUCT-SERVICE",configuration= ConsumerRibbonClientConfig.class)
        })
@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeComponent.class) })
//@RibbonClients(value = {
////        @RibbonClient(name = "client", configuration = RibbonClientConfiguration.class),
//        @RibbonClient(name = "product-service", configuration = RibbonProductServiceConfiguration.class)
//})
//@RibbonClient(name = "product-service", configuration = ProductServiceConfiguration.class)
public class ZuulServerDynamicApplication {

    @Bean
    // 需要使用负载均衡,必须与Bean一同使用
    @LoadBalanced
    public RestTemplate balanceRestTemplate() {
        return new RestTemplate();
    }

    //需要多个RestTemplate, 有的RestTemplate使用负载均衡，有的不使用,不使用的不增加@LoadBalanced注解
    @Primary
    @Bean
    public RestTemplate noBalanceRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerDynamicApplication.class, args);
    }

}
