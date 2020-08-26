package com.renho.mybatis.test.springboot.service.impl;

import com.renho.mybatis.test.springboot.aop.DynamicDataSourceAnnon;
import com.renho.mybatis.test.springboot.domain.po.Dept;
import com.renho.mybatis.test.springboot.mapper.DeptMapper;
import com.renho.mybatis.test.springboot.service.IDeptService;
import com.renho.mybatis.test.springboot.util.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Service
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private IDeptService deptService;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @DynamicDataSourceAnnon("dept")
    @Transactional
    @Override
    public String insert(Dept dept) {
        System.out.println("Thread: " + Thread.currentThread().getName());
        deptMapper.insert(dept);
        dept.setId(null);
        try {
            DynamicDataSource.setDataSource("default");
            deptService.insertOther(dept);
            DynamicDataSource.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dept.getId().toString();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public String insertOther(Dept dept) {
        deptMapper.insert(dept);
        int i = 100/0;
        return null;
    }
}
