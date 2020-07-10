package com.renho.security;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyAccessDecisionManager implements AccessDecisionManager, InitializingBean {


    private List<AntPathRequestMatcher> cachedPermitAllRequestMatcher;

    public MyAccessDecisionManager() {
        cachedPermitAllRequestMatcher = new ArrayList<>();
        cachedPermitAllRequestMatcher.add(new AntPathRequestMatcher("/api/auth/login"));
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        cachedPermitAllRequestMatcher = new ArrayList<>();
        cachedPermitAllRequestMatcher.add(new AntPathRequestMatcher("/api/auth/login"));

    }

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        if (isPermitAllUrl(request)) {
            return;
        }
        for (GrantedAuthority authority : authentication.getAuthorities()) {

            if (authority instanceof SimpleGrantedAuthority) {
                SimpleGrantedAuthority leafGrantedAuthority = (SimpleGrantedAuthority) authority;
                String requestPath = leafGrantedAuthority.getAuthority();
                if (requestPath != null) {
                    AntPathRequestMatcher matcher = new AntPathRequestMatcher(requestPath);
                    if (isMatchUrl(matcher, request)) {
                        return;
                    }
                }

            }
        }
        throw new AccessDeniedException("您没有权限使用:" + request.getRequestURI());

    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        System.out.printf("supports\n");
        return true;

    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

    /**
     *
     * @param request
     * @return
     */
    private boolean isPermitAllUrl(HttpServletRequest request) {
        for (AntPathRequestMatcher matcher : cachedPermitAllRequestMatcher) {
            if (matcher.matches(request)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMatchUrl(AntPathRequestMatcher matcher, HttpServletRequest request) {
        return matcher.matches(request);
    }

}
