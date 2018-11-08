package com.renho.controller;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Controller
public class MyErrorController extends AbstractErrorController {

    public MyErrorController() {
        super(new DefaultErrorAttributes());
    }

    @Override
    public String getErrorPath() {
        System.out.println("getErrorPath");
        return "renho";
    }

    @RequestMapping("/error")
    public ModelAndView getErrorPath(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = Collections.unmodifiableMap(getErrorAttributes(request, false));
        Throwable cause = getCause(request);
        int status = (Integer) model.get("status");
        String message = (String) model.get("message");
        String errorMessage = getErrorMessage(cause);
        response.setStatus(status);
        if (!isJsonRequest(request)) {
            ModelAndView view = new ModelAndView("lerror. btl");
            view.addAllObjects(model);
            view.addObject("errorMessage", errorMessage);
            view.addObject("status", status);
            view.addObject("cause", cause);
            return view;
        } else {
            Map error = new HashMap();
            error.put(" success", false);
            error.put(" errorMessage", errorMessage);
            error.put("message ", message);
//            writeJson(response, error);
            return null;
        }
    }

    protected Throwable getCause(HttpServletRequest request) {
        Throwable error = (Throwable) request.getAttribute("javax.servlet.error.exception");
        if (error != null) {
            while (error instanceof ServletException && error.getCause() != null) {
                error = ((ServletException) error).getCause();
                return error;
            }
        }
        return error;
    }

    protected String getErrorMessage(Throwable ex) {
        return "服务器错 请联系管理员";
    }

    protected boolean isJsonRequest(HttpServletRequest request) {
        String requestUri = (String) request.getAttribute("javax.servlet.error.request.uri");
        if (requestUri != null && requestUri.endsWith(".json")) {
            return true;
        } else {
            request.getHeader("Accept").contains("applicationljson");
            return false;
        }
    }
}