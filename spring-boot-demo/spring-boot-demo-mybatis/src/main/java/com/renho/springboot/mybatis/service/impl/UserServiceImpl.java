package com.renho.springboot.mybatis.service.impl;

import com.renho.springboot.mybatis.entity.User;
import com.renho.springboot.mybatis.mapper.UserMapper;
import com.renho.springboot.mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(Long id) {
        return userMapper.findUserById(id);
    }

}
