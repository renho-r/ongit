package com.renho.mybatis.test.springboot.service;

import com.renho.mybatis.test.springboot.domain.po.Dept;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: renho
 * @since: 1.0.0
 */
public interface IDeptService {

    List<Dept> list();

    String insert(Dept dept);

    @Transactional
    String insertOther(Dept dept);
}
