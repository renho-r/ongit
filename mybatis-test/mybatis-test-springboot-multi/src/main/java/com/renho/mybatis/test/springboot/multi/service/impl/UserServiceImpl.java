package com.renho.mybatis.test.springboot.multi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.renho.mybatis.test.springboot.multi.domain.po.User;
import com.renho.mybatis.test.springboot.multi.mapper.UserMapper;
import com.renho.mybatis.test.springboot.multi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(User user) {
        userMapper.insert(user);
        return user.getId();
    }

    @Override
    public List<User> list() {
        return userMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public List<User> list(int count) {
        Page page = new Page(1, count);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("synced", 0);
        queryWrapper.or();
        queryWrapper.isNull("synced");
        this.userMapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public void update(User user) {
        this.userMapper.updateById(user);
    }
}
