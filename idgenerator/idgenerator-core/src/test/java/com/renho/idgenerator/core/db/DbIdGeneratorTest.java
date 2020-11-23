package com.renho.idgenerator.core.db;

import com.renho.idgenerator.core.db.config.DbIdGeneratorConfig;
import com.renho.idgenerator.core.db.mapper.SequenceMapper;
import com.renho.idgenerator.core.db.sequenceoperater.operater.MysqlSequenceOperaterImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Stream;

public class DbIdGeneratorTest {

    private static SqlSessionFactory sqlSessionFactory;
    private static HikariConfig hikariConfig;
    private static HikariDataSource hikariDataSource;

    @BeforeAll
    public static void setUp() {
        initDataSourceAndMybatis();
    }

    @Test
    public void getId() {

        SqlSession session = DbIdGeneratorTest.sqlSessionFactory.openSession();//mybatis sqlSessionFactory，未使用spring管理事务
        SequenceMapper sequenceMapper = session.getMapper(SequenceMapper.class);

        MysqlSequenceOperaterImpl mysqlSequenceOperater = new MysqlSequenceOperaterImpl();
        mysqlSequenceOperater.setSequenceMapper(sequenceMapper);

        DbIdGeneratorConfig dbIdGeneratorConfig = new DbIdGeneratorConfig();
        // 默认序列，不带参数get()方法返回序列
        dbIdGeneratorConfig.setSequenceName("GEN_SEQ_NAME");
        // 序列开始值(默认)
        dbIdGeneratorConfig.setStart(10000L);
        // 步长(默认)
        dbIdGeneratorConfig.setIncrement(20);
        // 序列最大值(默认)
        dbIdGeneratorConfig.setMax(Long.MAX_VALUE);

        DbIdGenerator dbIdGenerator = new DbIdGenerator();
        dbIdGenerator.setDbIdGeneratorConfig(dbIdGeneratorConfig);
        dbIdGenerator.setDbSequenceOperater(mysqlSequenceOperater);

        // 获取默认序列值
        Stream.generate(new Random()::nextInt)
                .limit(10)
                .forEach((index) -> System.out.println(dbIdGenerator.get()));
        // 指定序列值
        Stream.generate(new Random()::nextInt)
                .limit(20)
                .forEach((index) -> System.out.println(dbIdGenerator.get("TEST_SEQ")));
        Stream.generate(new Random()::nextInt)
                .limit(1000)
                .forEach((index) -> System.out.println(dbIdGenerator.get(this.getClass().getName())));

        session.commit();
        session.close();
    }

    private static void initDataSourceAndMybatis() {

        hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://myserver:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("root123");
        hikariDataSource = new HikariDataSource(hikariConfig);

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, hikariDataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(SequenceMapper.class);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }
}