package com.renho.mybatis.test.springboot.multi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.renho.mybatis.test.springboot.multi.domain.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
