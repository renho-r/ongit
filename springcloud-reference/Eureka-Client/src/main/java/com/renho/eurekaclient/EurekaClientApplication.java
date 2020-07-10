package com.renho.eurekaclient;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableEurekaClient
@RestController
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @Autowired
    private EurekaClient eurekaDiscoveryClient;

    @RequestMapping("/serviceUrl")
    public String serviceUrl() {
        InstanceInfo instance = eurekaDiscoveryClient.getNextServerFromEureka("EUREKA-CLIENT", false);
        return instance.getHomePageUrl();
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/dserviceUrl")
    public String dserviceUrl() {
        List<ServiceInstance> list = discoveryClient.getInstances("EUREKA-CLIENT");
        if (list != null && list.size() > 0 ) {
            return String.valueOf(list.get(0).getUri());
        }
        return null;
    }
}
