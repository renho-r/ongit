package com.renho.zuul.service.impl;

import com.renho.zuul.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Service
public class OAuthServiceImpl implements IAuthService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public OAuth2AccessToken login(String username, String password) {
        HttpHeaders reqHeaders = new HttpHeaders();
        reqHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> formParams = new LinkedMultiValueMap<>();
        formParams.set("username", username);
        formParams.set("password", password);
        formParams.set("grant_type", "password");
        formParams.set("scope", "all");
        formParams.set("client_id", "r");
        formParams.set("client_secret", "r");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(formParams, reqHeaders);
        ResponseEntity<OAuth2AccessToken> responseEntity = restTemplate.postForEntity("http://AUTH/oauth/token", entity,
                OAuth2AccessToken.class);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
                    responseEntity.getStatusCodeValue();
            throw new HttpClientErrorException(responseEntity.getStatusCode());
        }
        return responseEntity.getBody();
    }

}
