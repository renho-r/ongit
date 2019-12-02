package com.renho.oauth2authserver.service;

import com.renho.oauth2authserver.domain.po.UserPO;
import com.renho.oauth2authserver.mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author: xxxxx
 * @since: 1.0.0
 */
@Service("userDetailService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPO user = userMapper.findByUsername(username);
        List<GrantedAuthority> grantedAuthoritys = new ArrayList<>();
        grantedAuthoritys.add(new SimpleGrantedAuthority("*"));
        return new User(user.getUsername(), "{noop}" + user.getPassword(), grantedAuthoritys);
    }

}
