package com.renho.oauth2authserver.config;

import com.renho.oauth2authserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Component
public class MyAuthenticationProvider extends DaoAuthenticationProvider {

    @Autowired
    public MyAuthenticationProvider(UserDetailsService userDetailService) {
        this.setUserDetailsService(userDetailService);
    }

    /**
     * 自定义验证方式
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        User user = (User) this.getUserDetailsService().loadUserByUsername(username);

        Authentication authenticationToken = null;
        if(null!=user && user.getPassword().equals(password)) {
            Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
            authenticationToken = new UsernamePasswordAuthenticationToken(null, password, authorities);
            authenticationToken.setAuthenticated(false);
        }
        return authenticationToken;

    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

}
