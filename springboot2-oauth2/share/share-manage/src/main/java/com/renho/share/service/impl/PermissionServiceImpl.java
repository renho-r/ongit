package com.renho.share.service.impl;


import com.renho.share.service.PermissionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lengleng
 * @date 2017/10/28
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
//    @Autowired
//    private MenuService menuService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        //ele-admin options 跨域配置，现在处理是通过前端配置代理，不使用这种方式，存在风险
//        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(request.getMethod())) {
//            return true;
//        }
        Object principal = authentication.getPrincipal();
        List<SimpleGrantedAuthority> grantedAuthorityList = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
        boolean hasPermission = false;

        if (principal != null) {
            if (CollectionUtils.isEmpty(grantedAuthorityList)) {
                return hasPermission;
            }
            for(SimpleGrantedAuthority simpleGrantedAuthority: grantedAuthorityList) {
                if("*".equalsIgnoreCase(simpleGrantedAuthority.getAuthority())) {
                    hasPermission = true;
                    break;
                }
                if(request.getRequestURI().equalsIgnoreCase(simpleGrantedAuthority.getAuthority())) {
                    hasPermission = true;
                    break;
                }
            }
        }
        return hasPermission;
    }
}
