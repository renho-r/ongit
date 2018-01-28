package com.renho.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author renho
 * @since: 2017/8/31
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String _index(HttpServletRequest request) {
        return "index";
    }

    @RequestMapping(value = "/user")
    public String user() {
        return "user";
<<<<<<< HEAD
    }

    @RequestMapping(value = "/{menuId}")
    public String views(@PathVariable String menuId) {
        return menuId;
=======
>>>>>>> 6f2ae9aa9c7ba01d0743444b4e1f9082cc8af3da
    }
}
