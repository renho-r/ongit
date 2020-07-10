package com.renho.springbootzk.controller;

import com.renho.springbootzk.config.ApplicationContextHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    @RequestMapping("/info")
    public Object get() {
        return ApplicationContextHelper.getAc().getEnvironment();
    }

}
