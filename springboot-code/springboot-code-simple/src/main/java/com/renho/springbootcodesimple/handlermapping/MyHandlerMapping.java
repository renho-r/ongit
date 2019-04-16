package com.renho.springbootcodesimple.handlermapping;

import com.renho.springbootcodesimple.controller.EnvController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.AbstractUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class MyHandlerMapping extends AbstractUrlHandlerMapping {

    private EnvController envController;
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    public MyHandlerMapping(EnvController envController, RequestMappingHandlerMapping requestMappingHandlerMapping) {
        this.envController = envController;
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
        setOrder(-2000);
    }

    @Override
    protected Object lookupHandler(String urlPath, HttpServletRequest request) throws Exception {
        return requestMappingHandlerMapping.getHandler(request);
    }

}
