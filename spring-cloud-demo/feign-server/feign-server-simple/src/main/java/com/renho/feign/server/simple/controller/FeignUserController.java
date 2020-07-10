package com.renho.feign.server.simple.controller;

import com.renho.feign.server.simple.service.IFeignUserService;
import com.renho.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: renho
 * @since: 1.0.0
 */

@RestController
@RequestMapping("/feign/user")
public class FeignUserController {

    @Autowired
    private IFeignUserService feignUserService;

    @GetMapping("/info/{name}")
    public UserVo info(@PathVariable String name) {
        return feignUserService.userInfoFromClientOne(name);
    }

}
