package com.renho.springboot.mybatis.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.renho.springboot.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserPlusMapper extends BaseMapper<User> {

    IPage<Object> selectPage(QueryWrapper<User> queryWrapper, Page page);
}
