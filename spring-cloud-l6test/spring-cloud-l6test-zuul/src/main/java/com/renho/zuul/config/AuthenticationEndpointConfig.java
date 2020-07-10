package com.renho.zuul.config;

import com.renho.zuul.service.ITokenExchangeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.authentication.TokenExtractor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AuthenticationEndpointConfig {

    @Bean
    @Qualifier("loadBalancedRestTemplate")
    public RestTemplate loadBalancedRestTemplate(RestTemplateCustomizer customizer) {
        RestTemplate restTemplate = new RestTemplate();
        customizer.customize(restTemplate);
        return restTemplate;
    }

    @Bean
    public TokenExtractor jwtTokenExtractor(ITokenExchangeService tokenExchangeService) {
        return new JwtTokenExtractor(tokenExchangeService);
    }

}
