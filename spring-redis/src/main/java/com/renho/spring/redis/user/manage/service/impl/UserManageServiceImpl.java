package com.renho.spring.redis.user.manage.service.impl;

import com.renho.spring.redis.user.manage.dao.UserMapper;
import com.renho.spring.redis.user.manage.domain.po.User;
import com.renho.spring.redis.user.manage.service.IUserManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserManageServiceImpl implements IUserManageService {

    @Resource
    private UserMapper userMapper;

    public List<User> getUsers() {
        return userMapper.selectAllUser();
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

}
