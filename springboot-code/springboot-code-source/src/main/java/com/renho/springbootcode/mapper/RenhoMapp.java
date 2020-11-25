package com.renho.springbootcode.mapper;

import com.renho.springbootcode.domain.pojo.TbUser;

import java.util.List;

/**
 * @author renho
 * @date 2020/11/25
 */
public interface RenhoMapp {

    List<TbUser> findAllUser();

    boolean insert(TbUser user);

}
