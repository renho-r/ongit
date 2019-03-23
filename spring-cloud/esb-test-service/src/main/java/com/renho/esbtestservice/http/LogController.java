package com.renho.esbtestservice.http;

import com.renho.esbtestservice.ws.bean.RespBody;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther: renho
 * @since: 1.0.0
 */

@RestController
@RequestMapping("api/http/log")
public class LogController {

    @RequestMapping(value = "log", method = RequestMethod.POST)
    public RespBody log(@RequestBody String busiBody) {
        System.out.printf("HTTP: LogController.log------>get req msg: %s\n", busiBody);
        return new RespBody("HTTP: LogController.log", busiBody);
    }

    @RequestMapping(value = "detail", method = RequestMethod.POST)
    public RespBody log(HttpServletRequest request, @RequestBody String body) {
        System.out.printf("HTTP: LogController.log------>get req msg: %s\n", request);
        return new RespBody("HTTP: LogController.log", "");
    }

}
