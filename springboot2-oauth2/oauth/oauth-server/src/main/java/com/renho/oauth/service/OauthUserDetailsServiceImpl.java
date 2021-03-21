package com.renho.oauth.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Service
public class OauthUserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("renho".equals(username)) {
            List<GrantedAuthority> gas = new ArrayList();
            gas.add(new SimpleGrantedAuthority("role1"));
            gas.add(new SimpleGrantedAuthority("role2"));
            gas.add(new SimpleGrantedAuthority("role3"));
            return new User("renho", "{noop}123456", gas);
        } else if ("admin".equals(username)) {
            List<GrantedAuthority> gas = new ArrayList();
            gas.add(new SimpleGrantedAuthority("all"));
            return new User("admin", "{noop}123456", gas);
        } else {
            return null;
        }
    }

}
