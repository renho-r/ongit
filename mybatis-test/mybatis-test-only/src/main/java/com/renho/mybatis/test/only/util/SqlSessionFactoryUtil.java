package com.renho.mybatis.test.only.util;

import com.renho.mybatis.test.only.config.MyConfiguration;
import com.renho.mybatis.test.only.mapper.BlogMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class SqlSessionFactoryUtil {

    public static SqlSessionFactory getSqlSessionFactory() {

        return getSqlSessionFactoryWithoutXml();
//        return getSqlSessionFactoryExtension();
    }

    public static SqlSessionFactory getSqlSessionFactoryExtension() {

        DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new MyConfiguration(environment);
        configuration.addMapper(BlogMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }

    public static SqlSessionFactory getSqlSessionFactoryFromXml() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    public static SqlSessionFactory getSqlSessionFactoryWithoutXml() {

        DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(BlogMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }

    private static class BlogDataSourceFactory {
        public static DataSource getBlogDataSource() {
            Properties properties = new Properties();
            properties.setProperty("driver", "com.mysql.jdbc.Driver");
            properties.setProperty("url", "jdbc:mysql://192.168.0.105:3306/mybatis");
            properties.setProperty("username", "root");
            properties.setProperty("password", "root123");
            PooledDataSourceFactory pooledDataSourceFactory = new PooledDataSourceFactory();
            pooledDataSourceFactory.setProperties(properties);
            DataSource dataSource = pooledDataSourceFactory.getDataSource();
            return dataSource;
        }
    }
}
