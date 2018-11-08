package com.renho.oauth.mapper;

import com.renho.oauth.domain.po.UserPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author: renho
 * @since: 1.0.0
 */
public interface IUserMapper {

    UserPO getUserByNameAndPassword(@Param("username") String username, @Param("password") String password);
    UserPO findByUsername(String username);
}
