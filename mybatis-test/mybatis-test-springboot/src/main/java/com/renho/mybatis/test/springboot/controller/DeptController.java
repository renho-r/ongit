package com.renho.mybatis.test.springboot.controller;

import com.renho.mybatis.test.springboot.domain.po.Dept;
import com.renho.mybatis.test.springboot.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author: renho
 * @since: 1.0.0
 */
@RestController
@RequestMapping("/api/dept")
public class DeptController {

    @Autowired
    private IDeptService deptService;

    @RequestMapping("/list")
    public List<Dept> list() {
        return deptService.list();
    }

    @RequestMapping("/insert")
    public String insert() {
        Dept dept = new Dept();
        dept.setName("dept-" + UUID.randomUUID().toString().replaceAll("\\-", ""));
        return deptService.insert(dept);
    }

}
