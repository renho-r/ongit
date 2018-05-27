package com.biaobai.auth.feign.fallback;

import com.biaobai.auth.feign.UserService;
import com.biaobai.auth.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceFallbackImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserVo findUserByUsername(String username) {
        logger.error("调用{}异常:{}", "findUserByUsername", username);
        return null;
    }

    /**
     * 通过手机号查询用户、角色信息
     *
     * @param mobile 手机号
     * @return UserVo
     */
    @Override
    public UserVo findUserByMobile(String mobile) {
        logger.error("调用{}异常:{}", "通过手机号查询用户", mobile);
        return null;
    }

    /**
     * 根据OpenId查询用户信息
     *
     * @param openId openId
     * @return UserVo
     */
    @Override
    public UserVo findUserByOpenId(String openId) {
        logger.error("调用{}异常:{}", "通过OpenId查询用户", openId);
        return null;
    }
}
