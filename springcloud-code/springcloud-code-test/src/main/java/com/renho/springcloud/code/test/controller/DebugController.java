package com.renho.springcloud.code.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Controller
@RequestMapping
public class DebugController {

    @RequestMapping("/**")
    @ResponseBody
    public String debug(HttpServletRequest request) {
        System.out.printf("request.getRequestURI(): %s\n", request.getRequestURI());
        return request.getRequestURI();
    }

}
