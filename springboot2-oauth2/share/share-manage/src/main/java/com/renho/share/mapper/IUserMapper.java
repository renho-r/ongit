package com.renho.share.mapper;

import com.renho.share.domain.po.UserPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author: renho
 * @since: 1.0.0
 */
public interface IUserMapper {

    UserPO getUserByNameAndPassword(@Param("username")String username, @Param("password")String password);
    UserPO findByUsername(String username);
}
