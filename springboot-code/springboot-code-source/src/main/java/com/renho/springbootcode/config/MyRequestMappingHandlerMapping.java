package com.renho.springbootcode.config;

import com.renho.springbootcode.controller.RenhoController;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author renho
 * @date 2020/11/27
 */
public class MyRequestMappingHandlerMapping implements Ordered, HandlerMapping {

    @Override
    public int getOrder() {
        return 3;
    }

    @Override
    public HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {
        String lookUpPath = request.getRequestURI();
        if ("/renho/test".equals(lookUpPath)) {
            return new HandlerExecutionChain(new RenhoController());
        }
        return null;
    }
}
