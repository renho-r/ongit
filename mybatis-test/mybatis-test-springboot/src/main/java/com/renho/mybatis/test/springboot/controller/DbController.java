package com.renho.mybatis.test.springboot.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.renho.mybatis.test.springboot.util.DynamicDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: renho
 * @since: 1.0.0
 */
@RestController
@RequestMapping("/api/db")
public class DbController {

    @RequestMapping("/init")
    public String init() {

        DruidDataSource userDataSource = new DruidDataSource();
        userDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        userDataSource.setUrl("jdbc:mysql://192.168.0.105:3306/user?characterEncoding=utf8");
        userDataSource.setUsername("root");
        userDataSource.setPassword("root123");
        DynamicDataSource.dataSourcesMap.put("user", userDataSource);

        DruidDataSource deptDataSource = new DruidDataSource();
        deptDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        deptDataSource.setUrl("jdbc:mysql://192.168.0.105:3306/dept?characterEncoding=utf8");
        deptDataSource.setUsername("root");
        deptDataSource.setPassword("root123");
        DynamicDataSource.dataSourcesMap.put("dept", deptDataSource);

        return "init success";
    }

}
