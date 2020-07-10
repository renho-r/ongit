package com.renho.user.controller;

import com.renho.vo.UserVo;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * @author: renho
 * @since: 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/info/{name}")
    public UserVo info(@PathVariable String name, HttpServletRequest request) {

        UserVo userVo = new UserVo();
        userVo.setId((new Random()).nextLong());
        userVo.setName(name);
        userVo.setInfo("user:port: " + request.getLocalPort());
        return userVo;
    }

}
