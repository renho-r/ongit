package com.renho.springboot.mybatis.mapper;

import com.renho.springboot.mybatis.entity.User;

public interface UserMapper {

    User findUserById(Long id);

}
