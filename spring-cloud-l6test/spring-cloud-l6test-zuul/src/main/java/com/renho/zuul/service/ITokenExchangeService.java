package com.renho.zuul.service;

import org.springframework.security.oauth2.common.OAuth2AccessToken;

public interface ITokenExchangeService {

    String getOAuth2AccessTokenValueById(String id);

    OAuth2AccessToken getOAuth2AccessTokenById(String id);

    String storeAuth2AccessToken(OAuth2AccessToken accessToken);

    void storeAuth2AccessToken(String id, OAuth2AccessToken accessToken);

}
