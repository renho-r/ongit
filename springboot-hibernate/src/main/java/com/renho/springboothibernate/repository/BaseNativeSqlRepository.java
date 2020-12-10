package com.renho.springboothibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.*;
import java.util.List;

/**
 * @author renho
 * @date 2020/12/10
 */
@Repository
public class BaseNativeSqlRepository {

    @PersistenceUnit
    private EntityManagerFactory emf;
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    public <R> List<R> query(String sql, Class<R> clazz){
//        EntityManager em = emf.createEntityManager();
        Query query = em.createNativeQuery(sql, clazz);
        List<R> list = query.getResultList();
//        em.close();
        return list;
    }

    @Modifying
    public void setEnv(String envSql, String value){
//        EntityManager em = emf.createEntityManager();
        final Query[] query = {null};
//        TransactionTemplate transactionTemplate = new TransactionTemplate(platformTransactionManager);
//        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus status) {
                query[0] = em.createNativeQuery(envSql);
                query[0].setParameter(1, value);
                query[0].executeUpdate();
//            }
//        });


        String sql = "SELECT @BLOG_NAME FROM DUAL";
//        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus status) {
                query[0] = em.createNativeQuery(sql);
                List result = query[0].getResultList();
//            }
//        });

//        em.close();
    }

    @Modifying
    public void insertByEnv(String insertSql) {
//        EntityManager em = emf.createEntityManager();
//        TransactionTemplate transactionTemplate = new TransactionTemplate(platformTransactionManager);
        String sql = "SET @BLOG_NAME = 'NAME-RENHO'; \n SET @BLOG_ADDRESS = 'NAME-ADDRESS';";
        final Query[] query = {null};
//        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus status) {
                query[0] = em.createNativeQuery(sql);
                query[0].executeUpdate();
//            }
//        });
//        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus status) {
                query[0] = em.createNativeQuery(insertSql);
                query[0].executeUpdate();
//            }
//        });
//        em.close();
    }

    public String getEnv(String sql) {

        Query query = em.createNativeQuery(sql);
        List<Object[]> result = query.getResultList();
        return String.valueOf(result.get(0));
    }
}
