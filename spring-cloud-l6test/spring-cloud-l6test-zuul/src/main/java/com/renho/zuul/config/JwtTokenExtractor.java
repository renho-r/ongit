package com.renho.zuul.config;

import com.renho.zuul.service.ITokenExchangeService;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class JwtTokenExtractor extends BearerTokenExtractor {

    private static final String ACCESS_TOKEN_HEADER = "Access-Token";

    private final ITokenExchangeService tokenExchangeService;

    public JwtTokenExtractor(ITokenExchangeService tokenExchangeService) {
        this.tokenExchangeService = tokenExchangeService;
    }

    @Override
    protected String extractToken(HttpServletRequest request) {
        String result = super.extractToken(request);
        if (result == null) {
            result = extractAccessToken(request);
        }
        return result;
    }

    private String extractAccessToken(HttpServletRequest request) {
        Enumeration<String> headers = request.getHeaders(ACCESS_TOKEN_HEADER);
        OAuth2AccessToken oAuth2AccessToken = null;
        String tokenValue = null;
        while (headers.hasMoreElements()) {
            tokenValue = headers.nextElement();
            oAuth2AccessToken = tokenExchangeService.getOAuth2AccessTokenById(tokenValue);
            break;
        }
        if (oAuth2AccessToken != null) {
            if (!oAuth2AccessToken.isExpired()) {
                return oAuth2AccessToken.getValue();
            }
        }
        return null;
    }

}
