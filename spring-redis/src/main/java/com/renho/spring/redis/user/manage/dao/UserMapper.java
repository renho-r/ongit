package com.renho.spring.redis.user.manage.dao;

import com.renho.spring.redis.user.manage.domain.po.User;

import java.util.List;

public interface UserMapper {

    public User selectByPrimaryKey(int userId);

    public List<User> selectAllUser();

    public void insertUser(User user);

    public void deleteUser(int id);

    public List<User> findUsers(String keyWords);

    public void editUser(User user);
}
