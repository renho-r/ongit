package com.renho.share.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Controller
@RequestMapping("/res")
public class ResController {

    @RequestMapping("")
    public String index() {
        return "res/index";
    }
}
