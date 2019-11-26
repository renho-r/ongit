package com.renho.zuul.service.impl;

import com.renho.zuul.service.ITokenExchangeService;
import com.renho.zuul.util.CacheUtil;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MyTokenExchangeServiceImpl implements ITokenExchangeService {

    @Override
    public String getOAuth2AccessTokenValueById(String id) {
        OAuth2AccessToken oAuth2AccessToken = getOAuth2AccessTokenById(id);
        if (oAuth2AccessToken != null) {
            return oAuth2AccessToken.getValue();
        }
        return null;
    }

    @Override
    public OAuth2AccessToken getOAuth2AccessTokenById(String id) {
        OAuth2AccessToken oAuth2AccessToken = (OAuth2AccessToken) CacheUtil.INSTANCE.getToken(id);
        return oAuth2AccessToken;
    }

    @Override
    public String storeAuth2AccessToken(OAuth2AccessToken accessToken) {
        if (accessToken != null) {
            String id = UUID.randomUUID().toString();
            storeAuth2AccessToken(id, accessToken);
            return id;
        }
        return null;
    }

    @Override
    public void storeAuth2AccessToken(String id, OAuth2AccessToken accessToken) {
        if (accessToken != null) {
            CacheUtil.INSTANCE.setCache(id, accessToken);
        }
    }

}
