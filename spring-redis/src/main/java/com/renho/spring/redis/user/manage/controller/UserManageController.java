package com.renho.spring.redis.user.manage.controller;

import com.renho.spring.redis.user.manage.domain.po.User;
import com.renho.spring.redis.user.manage.service.IUserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user/manage")
public class UserManageController {

    @Autowired
    private IUserManageService userManageService;

    @RequestMapping("/index")
    public String index() {
        return "user/manage/index";
    }

    @RequestMapping("/getUsers")
    public String getUsers(Model model) {
        List<User> users = userManageService.getUsers();
        model.addAttribute("users", users);
        return "user/manage/getUsers";
    }

    @RequestMapping("/insertUsers")
    public String insertUsers() {
        User user = new User();
        user.setUserName(UUID.randomUUID().toString().replaceAll("-", ""));
        userManageService.insertUser(user);
        return "redirect:/user/manage/index";
    }

}
