package com.renho.esbtestservice.http;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */

@RestController
public class DrController {

    @RequestMapping("/**")
    public Map<String, String> vr(HttpServletRequest request) {
        String path = request.getServletPath();
        System.out.println(path);
        return new HashMap<String, String>(){{
            put("path", path);
        }};
    }

//    @RequestMapping("/virtual")
//    public String virtual() {
//        System.out.println("/virtual");
//        return "/virtual";
//    }
//
//    @RequestMapping("/virtual/renho")
//    public String virtualPlus() {
//        System.out.println("/virtual/renho");
//        return "/virtual";
//    }
//
//    @RequestMapping("/renho")
//    public String real() {
//        System.out.println("/renho");
//        return "/renho";
//    }

}
