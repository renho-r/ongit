package com.renho.springboot.mybatis.service;

import com.renho.springboot.mybatis.entity.User;

import java.util.List;

public interface IUserService {

    User findUserById(Long id);

    List<Object> query();
}
