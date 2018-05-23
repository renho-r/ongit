package com.renho.esbtestservice.http;

import com.renho.esbtestservice.ws.bean.RespBody;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: renho
 * @since: 1.0.0
 */

@RestController
@RequestMapping("api/http/auth")
public class AuthController {

    @ApiOperation(value="鉴权", notes="renho")
    @RequestMapping(value = "check", method = RequestMethod.POST)
    public RespBody check(@RequestBody String busiBody) {
        System.out.printf("HTTP: AuthController.check------>get req msg: %s\n", busiBody);
        return new RespBody("HTTP: AuthController.check", busiBody);
    }

    @RequestMapping(value = "log", method = RequestMethod.POST)
    public RespBody log(@RequestBody String busiBody) {
        System.out.printf("HTTP: AuthController.log------>get req msg: %s\n", busiBody);
        return new RespBody("HTTP: AuthController.log", busiBody);
    }

}
