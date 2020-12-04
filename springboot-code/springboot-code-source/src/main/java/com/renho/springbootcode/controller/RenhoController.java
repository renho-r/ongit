package com.renho.springbootcode.controller;

import com.renho.springbootcode.util.LogUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author renho
 * @date 2020/11/27
 */
@RestController
@RequestMapping("/renho")
public class RenhoController {

    public RenhoController() {
        LogUtil.mark();
    }

    @GetMapping
    public String test() {
        return "RenhoController.test";
    }

    @GetMapping("/normal")
    public String normal() {
        return "RenhoController.normal";
    }


}
