package com.renho.mybatis.test.only.util;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class SqlSessionFactoryUtilTest {

    @Test
    public void getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        assert null != sqlSessionFactory;
    }

    @Test
    public void getSqlSessionFactoryFromXml() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactoryFromXml();
        assert null != sqlSessionFactory;
    }

    @Test
    public void getSqlSessionFactoryWithoutXml() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactoryWithoutXml();
        assert null != sqlSessionFactory;
    }
}
