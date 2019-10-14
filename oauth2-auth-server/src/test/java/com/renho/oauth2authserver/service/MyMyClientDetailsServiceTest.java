package com.renho.oauth2authserver.service;

import com.renho.oauth2authserver.model.MyClientDetails;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: renho
 * @since: 1.0.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyMyClientDetailsServiceTest {

    @Resource
    private RedisTemplate<String, MyClientDetails> redisTemplate;

    @Before
    public void initClient() {

        MyClientDetails client = new MyClientDetails();
        client.setClientId("r");
        client.setClientSecret("rr");
        client.setAuthorizedGrantTypes("password,authorization_code,refresh_token,implicit,client_credentials");
        client.setScope("all");
        client.setAutoapprove("false");
        client.setAuthorities("ROLE_USER");
        client.setWebServerRedirectUri("http://www.baidu.com");
        redisTemplate.opsForValue().set("oauth2:client:" + client.getClientId(), client);
    }

    @Test
    public void testLoadUserByUsername() {
        MyClientDetails client = redisTemplate.opsForValue().get("oauth2:client:r");
        System.out.printf("%s\n", client.toString());
    }

}
