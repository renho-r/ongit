package com.renho.userservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/info")
    public String userInfo(HttpServletRequest request) throws UnknownHostException {
        return String.format("%s: %s", "/user/info", request.getLocalPort());
    }

}
