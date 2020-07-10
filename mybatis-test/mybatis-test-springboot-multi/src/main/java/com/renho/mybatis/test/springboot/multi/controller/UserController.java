package com.renho.mybatis.test.springboot.multi.controller;

import com.renho.mybatis.test.springboot.multi.domain.po.User;
import com.renho.mybatis.test.springboot.multi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: renho
 * @since: 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/list")
    public List<User> list() {
        return userService.list();
    }

    @RequestMapping("/add")
    public Integer insert(@RequestBody User user) {
        return userService.insert(user);
    }

}
