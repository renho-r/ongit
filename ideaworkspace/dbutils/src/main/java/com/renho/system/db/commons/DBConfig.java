package com.renho.system.db.commons;

import com.renho.system.db.commons.dao.CommonHibernateDao;
import com.renho.system.db.commons.dao.CommonJdbcDao;
import com.renho.system.db.commons.dao.impl.CommonHibernateDaoImpl;
import com.renho.system.db.commons.dao.impl.CommonJdbcDaoImpl;
import org.hibernate.SessionFactory;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class DBConfig {

    private CommonHibernateDao mainHibernateDao = new CommonHibernateDaoImpl();
    private CommonJdbcDao mainJdbcDao = new CommonJdbcDaoImpl();
    private List<CommonHibernateDao> hibernateDaos = new ArrayList();
    private List<CommonJdbcDao> jdbcDaos = new ArrayList();

    public void setDataSource(DataSource dataSource) {
        this.mainJdbcDao.setDataSource(dataSource);
        this.jdbcDaos.add(mainJdbcDao);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.mainHibernateDao.setSessionFactory(sessionFactory);
        this.hibernateDaos.add(mainHibernateDao);
    }

    public CommonHibernateDao getMainHibernateDao() {
        return mainHibernateDao;
    }

    public void setMainHibernateDao(CommonHibernateDao mainHibernateDao) {
        this.mainHibernateDao = mainHibernateDao;
    }

    public CommonJdbcDao getMainJdbcDao() {
        return mainJdbcDao;
    }

    public void setMainJdbcDao(CommonJdbcDao mainJdbcDao) {
        this.mainJdbcDao = mainJdbcDao;
    }

    public List<CommonHibernateDao> getHibernateDaos() {
        return hibernateDaos;
    }

    public void setHibernateDaos(List<CommonHibernateDao> hibernateDaos) {
        this.hibernateDaos = hibernateDaos;
    }

    public List<CommonJdbcDao> getJdbcDaos() {
        return jdbcDaos;
    }

    public void setJdbcDaos(List<CommonJdbcDao> jdbcDaos) {
        this.jdbcDaos = jdbcDaos;
    }
}
