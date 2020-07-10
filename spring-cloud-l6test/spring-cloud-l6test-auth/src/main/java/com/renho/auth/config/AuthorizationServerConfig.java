package com.renho.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private ClientDetailsService clientDetailsService;

    private TokenStore tokenStore;

    private AccessTokenConverter accessTokenConverter;

    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthorizationServerConfig(
            @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") @Qualifier("ClientDetailServiceImpl") ClientDetailsService clientDetailsService,
            TokenStore tokenStore, AccessTokenConverter accessTokenConverter,
            AuthenticationManager authenticationManager) {
        this.clientDetailsService = clientDetailsService;
        this.tokenStore = tokenStore;
        this.accessTokenConverter = accessTokenConverter;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(this.clientDetailsService);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                .tokenStore(this.tokenStore)
                .accessTokenConverter(this.accessTokenConverter)
                .authenticationManager(this.authenticationManager);
    }

}
