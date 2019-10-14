package com.renho.oauth2authserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Controller
public class OauthController {

    @RequestMapping("/login")
    public String login() {
        return "user/login";
    }

    @RequestMapping("/user")
    public String user() {
        return "renho";
    }
}
