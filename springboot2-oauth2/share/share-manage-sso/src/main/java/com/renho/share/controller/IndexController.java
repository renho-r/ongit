package com.renho.share.controller;

import com.renho.share.utils.UserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("")
    public String index() {
        return "res/index";
    }

    @RequestMapping("/hauth")
    public String hauth(HttpServletRequest request) {
        String username = UserUtils.getUserName(request);
        return "user/hauth";
    }

    @RequestMapping("/nauth")
    public String nauth() {
        return "user/nauth";
    }
}
