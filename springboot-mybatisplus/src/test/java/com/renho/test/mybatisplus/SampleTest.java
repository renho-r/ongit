package com.renho.test.mybatisplus;

import com.renho.test.mybatisplus.entity.pojo.*;
import com.renho.test.mybatisplus.mapper.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

/**
 * @author renho
 * @date 2020/10/23
 */
@SpringBootTest
public class SampleTest {

    @Autowired
    private AutoIdMapper autoIdMapper;
    @Autowired
    private NoneIdMapper noneIdMapper;
    @Autowired
    private InputIdMapper inputIdMapper;
    @Autowired
    private AssignIdMapper assignIdMapper;
    @Autowired
    private CustomKeySequenceIdMapper customKeySequenceIdMapper;

    @Test
    public void testAutoIdMapperInsert() {
        AutoId autoId = new AutoId();
        autoId.setName("testAutoIdMapperInsert");
        autoId.setCTime(getTime());
        this.autoIdMapper.insert(autoId);
    }

    @Test
    public void testNoneIdMapperInsert() {
        NoneId noneId = new NoneId();
        noneId.setName("testNoneIdMapperInsert");
        noneId.setCTime(getTime());
        this.noneIdMapper.insert(noneId);
    }

    @Test
    public void testAssignIdMapperInsert() {
        AssignId assignId = new AssignId();
        assignId.setName("testAssignIdMapperInsert");
        assignId.setCTime(getTime());
        this.assignIdMapper.insert(assignId);

        assignId = new AssignId();
        assignId.setName("testAssignIdMapperInsert");
        assignId.setCTime(getTime());
        this.assignIdMapper.insert(assignId);
    }

    @Test
    public void testInputIdMapperInsert() {
        InputId inputId = new InputId();
        inputId.setId(new Random().nextLong());
        inputId.setName("testInputIdMapperInsert");
        inputId.setCTime(getTime());
        this.inputIdMapper.insert(inputId);
    }

    @Test
    public void testCustomKeySequenceIdMapperInsert() {
        CustomKeySequenceId customKeySequenceId = new CustomKeySequenceId();
        customKeySequenceId.setName("testCustomKeySequenceIdMapperInsert");
        customKeySequenceId.setCTime(getTime());
        this.customKeySequenceIdMapper.insert(customKeySequenceId);

        customKeySequenceId = new CustomKeySequenceId();
        customKeySequenceId.setName("testCustomKeySequenceIdMapperInsert");
        customKeySequenceId.setCTime(getTime());
        this.customKeySequenceIdMapper.insert(customKeySequenceId);
    }

    private String getTime() {
        return String.valueOf(System.currentTimeMillis());
    }

}
