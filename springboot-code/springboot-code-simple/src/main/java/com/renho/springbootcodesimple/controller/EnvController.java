package com.renho.springbootcodesimple.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.StandardServletEnvironment;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@RestController
@RequestMapping("/env")
public class EnvController {

    @Resource
    private Environment env;

    @GetMapping("/info")
    public Map<String, Object> info() {
        return ((StandardServletEnvironment) env).getSystemEnvironment();
    }

}
