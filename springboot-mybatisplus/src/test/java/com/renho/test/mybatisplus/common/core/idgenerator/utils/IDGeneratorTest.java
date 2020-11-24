package com.renho.test.mybatisplus.common.core.idgenerator.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IDGeneratorTest {

    @Autowired
    private IDGenerator idGenerator;

    @Test
    void testNext() {

        for (int i=0; i<111; i++) {
            System.out.println(idGenerator.next("renho"));
        }
    }
}