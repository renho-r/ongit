package com.renho.nginxagent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "/index";
    }

}
