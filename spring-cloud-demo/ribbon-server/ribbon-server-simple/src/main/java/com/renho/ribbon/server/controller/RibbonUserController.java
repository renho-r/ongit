package com.renho.ribbon.server.controller;

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
@RequestMapping("/ribbon/user")
public class RibbonUserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/info/{name}")
    public UserVo info(@PathVariable String name) {
        return restTemplate.getForObject("http://user-service/user/info/" + name, UserVo.class);
    }

}
