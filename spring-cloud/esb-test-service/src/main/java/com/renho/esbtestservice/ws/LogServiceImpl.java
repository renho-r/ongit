package com.renho.esbtestservice.ws;

import com.renho.esbtestservice.utils.JsonUtil;
import com.renho.esbtestservice.ws.bean.RespBody;

import javax.jws.WebService;

/**
 * @auther: renho
 * @since: 1.0.0
 */
@WebService
public class LogServiceImpl implements ILogService {

    @Override
    public String log(String busiBody) {
        System.out.printf("WS: LogServiceImpl.log------>get req msg: %s\n", busiBody);
        RespBody respBody = new RespBody("WS: ILogService.log", busiBody);
        return JsonUtil.toJson(respBody);
    }
}
