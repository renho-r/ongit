package com.renho.auth.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Service("ClientDetailServiceImpl")
public class ClientDetailServiceImpl implements ClientDetailsService {

    private PasswordEncoder passwordEncoder;

    public ClientDetailServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        BaseClientDetails baseClientDetails = new BaseClientDetails();
        baseClientDetails.setClientId(clientId);
        baseClientDetails.setClientSecret(passwordEncoder.encode(clientId));
        baseClientDetails.setAuthorizedGrantTypes(new HashSet<String>(
                Arrays.asList("authorization_code", "refresh_token", "password", "client_credentials")));

        baseClientDetails.setScope(new HashSet<String>(Arrays.asList("write", "read", "all")));
        return baseClientDetails;
    }
}
