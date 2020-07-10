package com.renho.mybatis.test.springboot.service;

import com.renho.mybatis.test.springboot.domain.po.User;

import java.util.List;

/**
 * @author: renho
 * @since: 1.0.0
 */
public interface IUserService {

    List<User> list();

    String insert(User user);
}
