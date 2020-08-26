package com.renho.mybatis.test.springboot.mapper;

import com.renho.mybatis.test.springboot.domain.po.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Mapper
public interface DeptMapper {

    List<Dept> list();

    void insert(Dept dept);
}
