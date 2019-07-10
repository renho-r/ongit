package com.renho;

import com.renho.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Client {

    public static void main(String[] args) throws IOException {

        SqlSessionFactory sqlSessionFactory = xmlSqlSessionFactory();
//        SqlSessionFactory sqlSessionFactory = javaSqlSessionFactory();

        sqlSessionSelect(sqlSessionFactory);

    }

    private static void sqlSessionSelect(SqlSessionFactory sqlSessionFactory) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("com.renho.mapper.UserMapper.selectById", 1);
        System.out.println(user.toString());

        sqlSession.insert("com.renho.mapper.UserMapper.insert", user);
        sqlSession.commit();

        sqlSession.close();
    }

    private static SqlSessionFactory xmlSqlSessionFactory() throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;

    }

//    private static SqlSessionFactory javaSqlSessionFactory() {
//        DataSource dataSource = UserDataSourceFactory.getUserDataSource();
//        TransactionFactory transactionFactory = new JdbcTransactionFactory();
//        Environment environment = new Environment("development", transactionFactory, dataSource);
//        Configuration configuration = new Configuration(environment);
//        configuration.addMapper(UserMapper.class);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
//        return sqlSessionFactory;
//    }
}
