package com.renho.oauth2authserver.service;

import com.renho.oauth2authserver.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: renho
 * @since: 1.0.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyUserDetailsServiceTest {

    @Resource
    private RedisTemplate<String, User> redisTemplate;

    @Before
    public void initUser() {
        User user = new User("r", "r");
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setAuths("ROLE_SUPER");
        redisTemplate.opsForValue().set("oauth2:user:" + user.getUsername(), user);
    }

    @Test
    public void testLoadUserByUsername() {

        User user = redisTemplate.opsForValue().get("oauth2:user:r");
        System.out.printf("%s\n", user.toString());
    }

}
