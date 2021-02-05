package com.renho.springbootcode.config;

import com.renho.springbootcode.controller.RenhoController;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author renho
 * @date 2020/11/27
 */
public class MyHandlerAdapter implements HandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return handler instanceof RenhoController;
    }

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RenhoController renhoController = (RenhoController) handler;
        Object object = renhoController.test();
        ModelAndView mv = new ModelAndView();
        mv.setViewName(null);
        mv.setStatus(HttpStatus.OK);
//        mv.setView(new MappingJackson2JsonView());
        mv.setView(new MyView());
        mv.addObject(object);
        return mv;
    }

    @Override
    public long getLastModified(HttpServletRequest request, Object handler) {
        return 0;
    }
}
