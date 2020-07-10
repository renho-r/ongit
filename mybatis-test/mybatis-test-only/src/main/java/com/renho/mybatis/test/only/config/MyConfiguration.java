package com.renho.mybatis.test.only.config;

import org.apache.ibatis.binding.MapperRegistry;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class MyConfiguration extends Configuration {

    protected MapperRegistry mapperRegistry = new MyMapperRegistry(this);

    public MyConfiguration(Environment environment) {
        super(environment);
    }

    @Override
    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    @Override
    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }
}
