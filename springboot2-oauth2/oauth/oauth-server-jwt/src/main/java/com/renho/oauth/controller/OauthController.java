package com.renho.oauth.controller;

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

//    @RequestMapping("/oauth/confirm_access")
//    public String authorize() {
//        return "user/authorize";
//    }

}
