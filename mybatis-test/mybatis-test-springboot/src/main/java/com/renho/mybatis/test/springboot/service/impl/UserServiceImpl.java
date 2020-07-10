package com.renho.mybatis.test.springboot.service.impl;

import com.renho.mybatis.test.springboot.aop.DynamicDataSourceAnnon;
import com.renho.mybatis.test.springboot.domain.po.User;
import com.renho.mybatis.test.springboot.mapper.UserMapper;
import com.renho.mybatis.test.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Service
@DynamicDataSourceAnnon("user")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        System.out.println("Thread: " + Thread.currentThread().getName());
        return userMapper.list();
    }

    @Transactional
    @Override
    public String insert(User user) {
        System.out.println("Thread: " + Thread.currentThread().getName());
        userMapper.insert(user);
        return user.getId().toString();
    }
}
