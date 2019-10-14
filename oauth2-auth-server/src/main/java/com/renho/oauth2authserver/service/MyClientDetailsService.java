package com.renho.oauth2authserver.service;

import com.renho.oauth2authserver.model.MyClientDetails;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Component
public class MyClientDetailsService implements ClientDetailsService {

    @Resource
    private RedisTemplate<String, MyClientDetails> redisTemplate;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        MyClientDetails myClientDetails = redisTemplate.opsForValue().get("oauth2:client:" + clientId);

        if(null == myClientDetails) {
            throw new RuntimeException("no client");
        }

        BaseClientDetails baseClientDetails = new BaseClientDetails();
        baseClientDetails.setClientId(myClientDetails.getClientId());
        baseClientDetails.setClientSecret(myClientDetails.getClientSecret());
        baseClientDetails.setAuthorizedGrantTypes(Arrays.asList(myClientDetails.getAuthorizedGrantTypes().split(",")));
        baseClientDetails.setScope(Arrays.asList(myClientDetails.getScope().split(",")));
        baseClientDetails.setAutoApproveScopes(Arrays.asList(myClientDetails.getAutoapprove().split(",")));
        baseClientDetails.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(myClientDetails.getAuthorities()));


        Set<String> rus = new HashSet<>();
        for(String uri: myClientDetails.getWebServerRedirectUri().split(",")) {
            rus.add(uri);
        }
        baseClientDetails.setRegisteredRedirectUri(rus);
        baseClientDetails.setAccessTokenValiditySeconds(60);
        return baseClientDetails;
    }
}
