package com.renho.esbtestservice.ws;

import com.renho.esbtestservice.utils.JsonUtil;
import com.renho.esbtestservice.ws.bean.RespBody;

import javax.jws.WebService;

/**
 * @auther: renho
 * @since: 1.0.0
 */
@WebService
public class AuthServiceImpl implements IAuthService {

    @Override
    public String check(String busiBody) {
        System.out.printf("WS: IAuthService.check------>get req msg: %s\n", busiBody);
        RespBody respBody = new RespBody("WS: IAuthService.check", busiBody);
        return JsonUtil.toJson(respBody);
    }

    @Override
    public String log(String busiBody) {
        System.out.printf("WS: IAuthService.log------>get req msg: %s\n", busiBody);
        RespBody respBody = new RespBody("WS: IAuthService.log", busiBody);
        return JsonUtil.toJson(respBody);
    }


}
