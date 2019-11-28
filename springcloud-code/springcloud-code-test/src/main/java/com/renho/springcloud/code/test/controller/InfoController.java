package com.renho.springcloud.code.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: renho
 * @since: 1.0.0
 */
@RestController
@RequestMapping("/api/info")
public class InfoController {

    @Autowired
    private Environment env;

    @RequestMapping("/port")
    public String port() {
        return env.getProperty("server.port", "8080");
    }

}
