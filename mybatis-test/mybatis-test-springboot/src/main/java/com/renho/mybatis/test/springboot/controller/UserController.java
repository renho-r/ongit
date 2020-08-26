package com.renho.mybatis.test.springboot.controller;

import com.renho.mybatis.test.springboot.domain.po.User;
import com.renho.mybatis.test.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author: renho
 * @since: 1.0.0
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/list")
    public List<User> list() {
        return userService.list();
    }

    @RequestMapping("/insert")
    public String insert() {
        User user = new User();
        user.setName("user-" + UUID.randomUUID().toString().replaceAll("\\-", ""));
        return userService.insert(user);
    }

}
