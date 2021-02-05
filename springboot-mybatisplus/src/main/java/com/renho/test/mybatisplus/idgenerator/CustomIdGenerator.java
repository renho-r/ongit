package com.renho.test.mybatisplus.idgenerator;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.renho.test.mybatisplus.common.core.IdGen;

import javax.annotation.Resource;

/**
 * @author renho
 * @date 2020/10/23
 */
public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Long nextId(Object entity) {
        //可以将当前传入的class全类名来作为bizKey,或者提取参数来生成bizKey进行分布式Id调用生成.
        String bizKey = entity.getClass().getName();
        //根据bizKey调用分布式ID生成
        Long id = 123L;
        //返回生成的id值即可.
        return id;
    }
}