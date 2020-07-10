package com.renho.security.config;

import com.renho.security.MyUserAuthenticationConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Configuration
public class TokenAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    @ConditionalOnMissingBean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {

        DefaultAccessTokenConverter accessTokenConverter = new DefaultAccessTokenConverter();
        accessTokenConverter.setUserTokenConverter(new MyUserAuthenticationConverter());

        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("renho");
        converter.setAccessTokenConverter(accessTokenConverter);
        return converter;
    }

}
