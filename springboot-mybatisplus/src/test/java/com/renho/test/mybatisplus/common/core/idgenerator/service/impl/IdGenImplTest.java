package com.renho.test.mybatisplus.common.core.idgenerator.service.impl;

import com.renho.test.mybatisplus.common.core.IdGen;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IdGenImplTest {

    @Resource(name = "IdGenImpl")
    private IdGen idGen;
    @Resource(name = "snowFlowerIDGenImpl")
    private IdGen snowFlowerIDGenImpl;

    @Test
    void testGet() {
        String id = idGen.get("pro","renho",null,null).toString();
        System.out.println(id);
        id = idGen.get("pro","renho",null,null).toString();
        System.out.println(id);
        id = idGen.get("pro","renho",null,null).toString();
        System.out.println(id);
        id = idGen.get("pro","renho",null,null).toString();
        System.out.println(id);
        id = idGen.get("pro","renho",null,null).toString();
        System.out.println(id);
        id = snowFlowerIDGenImpl.get("sf",null,"192.168.0.1","8888").toString();
        System.out.println(id);
        id = snowFlowerIDGenImpl.get("sf",null,"192.168.0.1","8888").toString();
        System.out.println(id);
        id = snowFlowerIDGenImpl.get("sf",null,"192.168.0.1","8888").toString();
        System.out.println(id);
        id = snowFlowerIDGenImpl.get("sf",null,"192.168.0.1","8888").toString();
        System.out.println(id);
    }
}