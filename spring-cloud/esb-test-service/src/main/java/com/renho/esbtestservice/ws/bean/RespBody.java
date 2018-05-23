package com.renho.esbtestservice.ws.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther: renho
 * @since: 1.0.0
 */
public class RespBody {

    private String serviceMethod;
    private String reqMsg;
    private String time;

    public RespBody() {}

    public RespBody(String serviceMethod, String reqMsg) {
        this(serviceMethod, reqMsg, (new SimpleDateFormat("yyy-MM-dd HH:mm:ss SSS")).format(new Date()));
    }

    public RespBody(String serviceMethod, String reqMsg, String time) {
        this.serviceMethod = serviceMethod;
        this.reqMsg = reqMsg;
        this.time = time;
    }

    public String getReqMsg() {
        return reqMsg;
    }

    public void setReqMsg(String reqMsg) {
        this.reqMsg = reqMsg;
    }

    public String getServiceMethod() {
        return serviceMethod;
    }

    public void setServiceMethod(String serviceMethod) {
        this.serviceMethod = serviceMethod;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
