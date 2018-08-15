package com.renho.share.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lengleng
 * @date 2017-12-18
 * 验证码校验，true开启，false关闭校验
 * 更细化可以 clientId 进行区分
 */
@Component("validateCodeFilter")
public class ValidateCodeFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(ValidateCodeFilter.class);
    @Value("${security.validate.code:true}")
    private boolean isValidate;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        filterChain.doFilter(request, response);
    }
}
