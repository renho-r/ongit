package com.renho.histrix.server.simple.controller;

import com.renho.histrix.server.simple.service.IUserService;
import com.renho.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: renho
 * @since: 1.0.0
 */
@RestController
@RequestMapping("/histrix/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/info/{name}")
    public UserVo info(@PathVariable String name) {
        return userService.userInfoService(name);
    }

}
