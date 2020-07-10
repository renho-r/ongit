package com.renho.kongtestservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.StandardServletEnvironment;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@RestController
public class MatchAllController {

    @Autowired
    private Environment env;

    @Value("${server.port:8080}")
    private int port;

    @RequestMapping("/**")
    public Object echo(HttpServletRequest request) {
        Map map = new HashMap();
        map.put("env", ((StandardServletEnvironment) env).getSystemEnvironment());
        map.put("port", port);
        map.put("url", request.getRequestURL());
        map.put("header", new HashMap<>());
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headerName = headers.nextElement();
            ((Map)map.get("header")).put(headerName, request.getHeader(headerName));
        }
        return map;
    }

    @RequestMapping("/sleep/{second}")
    public Object sleep(HttpServletRequest request, @PathVariable Integer second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return echo(request);
    }
}
