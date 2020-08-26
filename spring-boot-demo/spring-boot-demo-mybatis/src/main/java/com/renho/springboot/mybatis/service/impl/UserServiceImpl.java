package com.renho.springboot.mybatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.renho.springboot.mybatis.entity.User;
import com.renho.springboot.mybatis.mapper.UserMapper;
import com.renho.springboot.mybatis.mapper.UserPlusMapper;
import com.renho.springboot.mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserPlusMapper userPlusMapper;

    @Override
    public User findUserById(Long id) {
        return userMapper.findUserById(id);
    }

    @Override
    public List<Object> query() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "r");
        Page page = new Page(1, 100);
        return userPlusMapper.selectPage(queryWrapper, page).getRecords();
    }

}
