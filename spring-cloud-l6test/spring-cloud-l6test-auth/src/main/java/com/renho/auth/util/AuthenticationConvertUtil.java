package com.renho.auth.util;

import com.renho.auth.config.CustomPasswordEncoder;
import com.renho.auth.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

public class AuthenticationConvertUtil {

    public static UserDetails convertUserAndResourcesDTOToLeafUserDetails(final User user) {
        final UserDetails userDetails = new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                Set<GrantedAuthority> auths = new HashSet<>();
                auths.add(new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return "/api/auth/whoami";
                    }
                });
                return auths;
            }

            @Override
            public String getPassword() {
                PasswordEncoder passwordEncoder = new CustomPasswordEncoder();
                return passwordEncoder.encode(user.getUserName());
            }

            @Override
            public String getUsername() {
                return user.getUserName();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
        return userDetails;
    }

}
