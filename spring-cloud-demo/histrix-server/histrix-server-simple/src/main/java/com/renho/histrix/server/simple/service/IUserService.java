package com.renho.histrix.server.simple.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.renho.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class IUserService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand//(fallbackMethod = "userInfoError")
    public UserVo userInfoService(String name) {
        return restTemplate.getForObject("http://USER-SERVICE/user/info/" + name, UserVo.class);
    }

    public UserVo userInfoError(String name) {
        UserVo userVo = new UserVo();
        userVo.setId((new Random()).nextLong());
        userVo.setName(name);
        userVo.setInfo("error: " + name);
        return userVo;
    }
}