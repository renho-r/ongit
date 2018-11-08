package com.renho.esbtestservice.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @auther: renho
 * @since: 1.0.0
 */
@WebService(name="log")
public interface ILogService {

    @WebResult
    @WebMethod
    String log(@WebParam(name="busiBody") String busiBody);

}
