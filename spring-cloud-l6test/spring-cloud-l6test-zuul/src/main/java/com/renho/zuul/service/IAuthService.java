package com.renho.zuul.service;

import org.springframework.security.oauth2.common.OAuth2AccessToken;

/**
 * @author: renho
 * @since: 1.0.0
 */
public interface IAuthService {
    OAuth2AccessToken login(String username, String password);
}
