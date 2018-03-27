package com.renho.springboot.mybatis.service;

import com.renho.springboot.mybatis.entity.User;

public interface IUserService {

    User findUserById(Long id);
}
