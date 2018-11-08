package com.renho.esbtestservice.http;

import com.renho.esbtestservice.ws.bean.RespBody;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther: renho
 * @since: 1.0.0
 */

@RestController
@RequestMapping("api/http/auth")
public class AuthController {

    private static AtomicInteger count = new AtomicInteger(0);

    @ApiOperation(value="鉴权", notes="renho")
    @RequestMapping(value = "check", method = RequestMethod.POST)
    public RespBody check(@RequestBody String busiBody) {
        System.out.printf("HTTP: AuthController.check------>get req msg: %s\n", busiBody);
        return new RespBody("HTTP: AuthController.check", busiBody);
    }

    @RequestMapping(value = "log", method = RequestMethod.POST)
    public RespBody logPost(@RequestBody String busiBody) {
        System.out.printf("HTTP: AuthController.log------>get req msg: %s\n", busiBody);
        return new RespBody("HTTP: AuthController.log", busiBody);
    }

    @RequestMapping(value = "logGetParam", method = RequestMethod.GET)
    public RespBody logGet(@RequestParam("busiId") String busiId) {
        System.out.printf("HTTP: AuthController.log------>get req msg: %s\n", busiId);
        return new RespBody("HTTP: AuthController.log", busiId);
    }

    @RequestMapping(value = "logGet", method = RequestMethod.GET)
    public RespBody logGet() {
        System.out.println(count.incrementAndGet());
        System.out.printf("HTTP: AuthController.log------>get req msg: %s\n", "default");
        return new RespBody("HTTP: AuthController.log", "default");
    }

}
