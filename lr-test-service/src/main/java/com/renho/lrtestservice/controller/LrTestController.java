package com.renho.lrtestservice.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author: renho
 * @since: 1.0.0
 */
@RestController
@RequestMapping("/api")
public class LrTestController {

    @RequestMapping("/none")
    public void none() {
        return;
    }

    @RequestMapping("/sleep/{second}")
    public void sleep(@PathVariable long second) {
        try {
            TimeUnit.MILLISECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/echo")
    @ResponseBody
    public Object echo(@RequestBody Object obj) {
        return obj;
    }

}
