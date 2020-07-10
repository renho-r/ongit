package com.renho.auth.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author: renho
 * @since: 1.0.0
 */
public interface UserService {

    UserDetails getUserInfoByUserName(String userName);
}
