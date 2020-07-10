package com.renho.eureka.client.simple.controller;

import com.renho.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author: renho
 * @since: 1.0.0
 */
@RestController
@RequestMapping("/eurekaclient")
public class EurekaClientController {

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/info/{name}")
    public UserVo userInfo(@PathVariable String name) {

        List<String> services = client.getServices();
        services.forEach(System.out::println);

        List<ServiceInstance> serviceInstances = client.getInstances("USER-SERVICE");

        ServiceInstance serviceInstance = serviceInstances.get(0);
        RestTemplate restTemplate = new RestTemplate();

        UserVo userVo = restTemplate.getForObject(serviceInstance.getUri() + "/user/info/" + name, UserVo.class);
        return userVo;

    }

    @GetMapping("/bl/user/info/{name}")
    public UserVo userInfoBl(@PathVariable String name) {

        UserVo userVo = restTemplate.getForObject("http://USER-SERVICE/user/info/" + name, UserVo.class);
        return userVo;

    }

}
