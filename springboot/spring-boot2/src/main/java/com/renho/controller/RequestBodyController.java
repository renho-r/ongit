package com.renho.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@RestController
@RequestMapping("/api/test")
public class RequestBodyController {

    private Log log = LogFactory.getLog(RequestBodyController.class);

    @PostMapping("/requestBodyJson")
    public String requestBodyJson(@RequestBody String req) {
        System.out.println(req);
        return "renho";
    }

    @RequestMapping("/now")
    public Map<String, Object> now() {
        if(log.isDebugEnabled()) {
            log.debug("renho");
        }
        return new HashMap(){{
            put("time", new Date());
        }};
    }

    @RequestMapping("/error")
    public String error() throws Exception {
        throw new Exception("error");
    }
}
