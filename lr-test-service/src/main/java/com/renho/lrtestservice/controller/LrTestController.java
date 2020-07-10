package com.renho.lrtestservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Api(value = "测试接口")
@RestController
@RequestMapping("/api")
public class LrTestController {

    @ApiOperation(value = "无处理", notes = "忽略请求数据，无处理，直接返回")
    @RequestMapping(value = "/none", method = {RequestMethod.GET, RequestMethod.POST})
    public void none() {
        return;
    }

    @ApiOperation(value = "sleep", notes = "毫秒")
    @RequestMapping(value = "/sleep/{millisecond}", method = {RequestMethod.GET, RequestMethod.POST})
    public void sleep(@PathVariable long millisecond) {
        try {
            TimeUnit.MILLISECONDS.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "echo", notes = "使用Object获取body，无处理直接返回")
    @PostMapping("/echo")
    @ResponseBody
    public Object echo(@RequestBody Object obj) {
        return obj;
    }

}
