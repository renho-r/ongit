package com.renho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@RestController
public class RemoteRestController {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @PostMapping("/remote/rest")
    public String remoteRest() {
        RestTemplate client = restTemplateBuilder.build();
        String result = client.getForObject("http://www.baidu.com", String.class);
        return result;
    }

}
