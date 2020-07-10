package com.renho.mybatis.test.springboot.multi.service;

import com.renho.mybatis.test.springboot.multi.domain.po.User;

import java.util.List;

/**
 * @author: renho
 * @since: 1.0.0
 */
public interface IUserService {

    int insert(User user);

    List<User> list();

    List<User> list(int count);

    void update(User user);
}
