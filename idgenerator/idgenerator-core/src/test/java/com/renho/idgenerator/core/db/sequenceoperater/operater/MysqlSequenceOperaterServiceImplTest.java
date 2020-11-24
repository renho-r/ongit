package com.renho.idgenerator.core.db.sequenceoperater.operater;

import com.renho.idgenerator.core.db.entity.po.Sequence;
import com.renho.idgenerator.core.db.mapper.SequenceMapper;
import com.renho.idgenerator.core.db.sequenceoperater.IDbSequenceOperater;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.jupiter.api.*;

public class MysqlSequenceOperaterServiceImplTest {

    private static SqlSessionFactory sqlSessionFactory;
    private static HikariConfig hikariConfig;
    private static HikariDataSource hikariDataSource;

    @BeforeAll
    public static void setUp() {

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

    @Test
    public void testInit() {

        Sequence sequence = new Sequence();
        sequence.setName("renho");
        sequence.setStart(10000L);
        sequence.setMax(Long.MAX_VALUE);
        sequence.setIncrement(10);
        SqlSession session = MysqlSequenceOperaterServiceImplTest.sqlSessionFactory.openSession();
        SequenceMapper sequenceMapper = session.getMapper(SequenceMapper.class);
        MysqlSequenceOperaterImpl mysqlSequenceOperaterServiceImpl = new MysqlSequenceOperaterImpl();
        mysqlSequenceOperaterServiceImpl.setSequenceMapper(sequenceMapper);
        IDbSequenceOperater dbSequenceOperaterService = mysqlSequenceOperaterServiceImpl;

        dbSequenceOperaterService.init(sequence);

        session.commit();
        session.close();
    }

    public void testLoad() {
    }

    public void testCurrent() {
    }

    @RepeatedTest(100)
    public void testNext() {
        Sequence sequence = new Sequence();
        sequence.setName("renho");
        sequence.setStart(10000L);
        sequence.setMax(Long.MAX_VALUE);
        sequence.setIncrement(10);
        SqlSession session = MysqlSequenceOperaterServiceImplTest.sqlSessionFactory.openSession();
        SequenceMapper sequenceMapper = session.getMapper(SequenceMapper.class);
        MysqlSequenceOperaterImpl mysqlSequenceOperaterServiceImpl = new MysqlSequenceOperaterImpl();
        mysqlSequenceOperaterServiceImpl.setSequenceMapper(sequenceMapper);
        IDbSequenceOperater dbSequenceOperaterService = mysqlSequenceOperaterServiceImpl;

        Long memMaxId = dbSequenceOperaterService.next(sequence).getCurrent();
        System.out.println(memMaxId);

        session.commit();
        session.close();
    }

    @AfterEach
    public void commit() {
    }
}