package com.renho.infoservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@RestController
@RequestMapping("/info")
public class InfoController {

    @PostMapping("/{id}")
    public String info(@PathVariable String id) {
        return "info: " + id;
    }

}
