package com.biaobai.auth.serivce;

import com.biaobai.auth.feign.UserService;
import com.biaobai.auth.util.UserDetailsImpl;
import com.biaobai.auth.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author lengleng
 * @date 2017/10/26
 * <p>
 */
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVo userVo = userService.findUserByUsername(username);
        return new UserDetailsImpl(userVo);
    }
}
