package com.renho.oauth2authserver.service;

import com.renho.oauth2authserver.model.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Service("userDetailService")
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private RedisTemplate<String, User> redisTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = redisTemplate.opsForValue().get("oauth2:user:" + username);
        if (null == user) {
            throw new RuntimeException("no user!");
        }
        return user;
    }

}
