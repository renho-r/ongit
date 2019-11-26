package com.renho.auth.service.impl;

import com.renho.auth.domain.User;
import com.renho.auth.service.UserService;
import com.renho.auth.util.AuthenticationConvertUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserDetails getUserInfoByUserName(String userName) {

        User user = new User(userName);
        return AuthenticationConvertUtil.convertUserAndResourcesDTOToLeafUserDetails(user);
    }

}
