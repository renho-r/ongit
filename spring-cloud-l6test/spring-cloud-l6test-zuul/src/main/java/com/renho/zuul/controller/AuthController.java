package com.renho.zuul.controller;

import com.renho.zuul.service.IAuthService;
import com.renho.zuul.service.ITokenExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: renho
 * @since: 1.0.0
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    public AuthController() {
        System.out.printf("init\n");
    }

    @Autowired
    private IAuthService authService;
    @Autowired
    private ITokenExchangeService tokenExchangeService;

    @RequestMapping("/login")
    public String token(String username, String password) {

        OAuth2AccessToken token = authService.login(username, password);
        String id = tokenExchangeService.storeAuth2AccessToken(token);
        return id;
    }

    @RequestMapping("/whoami")
    public String whoami() {
        return "renho";
    }
}
