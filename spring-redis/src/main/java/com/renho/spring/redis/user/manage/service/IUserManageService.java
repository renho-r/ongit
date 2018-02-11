package com.renho.spring.redis.user.manage.service;

import com.renho.spring.redis.user.manage.domain.po.User;

import java.util.List;

public interface IUserManageService {

    List<User> getUsers();
    void insertUser(User user);
}
