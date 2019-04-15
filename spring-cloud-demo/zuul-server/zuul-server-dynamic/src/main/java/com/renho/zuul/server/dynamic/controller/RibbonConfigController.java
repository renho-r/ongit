package com.renho.zuul.server.dynamic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonConfigController {

    // 注入restTemplate, 这个类已经在RibbonConsumerApplication中初始化,并且使用负载均衡
    @Autowired //默认按照类型注入,如果需要按照名字注入需要使用@Qualifier注解
    @LoadBalanced //使用带有负载均衡的RestTemplate
    private RestTemplate balanceRestTemplate;

    // 以下注入负载均衡客户端LoadBalancerClient是一个接口,下面只有一个RibbonLoadBalancerClient实现类
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RibbonLoadBalancerClient ribbonLoadBalancerClient;

    @GetMapping("/ribbon/product/{name}")
    public Object ribbon(@PathVariable("name") String name) {
        Object result;
        ServiceInstance instance = loadBalancerClient.choose("PRODUCT-SERVICE");
        System.out.println("host:" + instance.getHost() + ",port:" + instance.getPort() + ",serviceId=" + instance.getServiceId() + ",uri=" + instance.getUri());
        result = this.balanceRestTemplate.getForObject("http://" + instance.getServiceId() + "/product/info/" + name, Object.class);
        instance = ribbonLoadBalancerClient.choose("USER-SERVICE");
        System.out.println("host:" + instance.getHost() + ",port:" + instance.getPort() + ",serviceId=" + instance.getServiceId() + ",uri=" + instance.getUri());
        System.out.println("=============");
        return result;
    }

}
