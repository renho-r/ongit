package com.renho.springboot.mybatis.controller;

import com.renho.springboot.mybatis.entity.User;
import com.renho.springboot.mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/index")
    public String index() {
        return "user/index";
    }

    @RequestMapping(value = "/show")
    @ResponseBody
    public String show(@RequestParam(value = "id") Long id) {
        User user = userService.findUserById(id);
        if (null != user)
            return user.getId() + "/" + user.getName() + "/" + user.getPassword();
        else return "null";
    }

    @GetMapping("/query")
    @ResponseBody
    public List<Object> query() {
        return userService.query();
    }
}
