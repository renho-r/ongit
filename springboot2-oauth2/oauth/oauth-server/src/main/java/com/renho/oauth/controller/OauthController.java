package com.renho.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: renho
 * @since: 1.0.0
 */
//@Controller
public class OauthController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

//    @RequestMapping("/oauth/confirm_access")
//    public String authorize() {
//        return "user/authorize";
//    }

    @RequestMapping("/hauth")
    public String hauth() {
        return "user/hauth";
    }

    @RequestMapping("/nauth")
    public String nauth() {
        return "user/nauth";
    }
}
