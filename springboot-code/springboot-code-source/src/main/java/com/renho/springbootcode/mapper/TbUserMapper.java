package com.renho.springbootcode.mapper;

import com.renho.springbootcode.domain.pojo.TbUser;

import java.util.List;

/**
 * @author: renho
 * @since: 1.0.0
 */
public interface TbUserMapper {

    List<TbUser> findAllUser();

    boolean insert(TbUser user);

}
