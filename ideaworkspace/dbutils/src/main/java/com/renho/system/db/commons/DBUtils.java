package com.renho.system.db.commons;

import com.renho.system.db.commons.dao.CommonHibernateDao;
import com.renho.system.db.commons.dao.CommonJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBUtils {

    private static DBConfig dbConfig;

    public DBUtils() {
        System.out.println("init DBUtils");
    }

    public DBConfig getDbConfig() {
        return dbConfig;
    }

    @Autowired
    public void setDbConfig(DBConfig dbConfig) {
        DBUtils.dbConfig = dbConfig;
    }

    public static <T> void save(T po) {
        getHibernateDao().save(po);
    }

    public static <T> List<T> query(String sql, Class<T> clazz, Object ... orgs) {
        return getJdbcDao().query(sql, clazz, orgs);
    }

    public static <T> T getFirst(String sql, Class<T> clazz, Object ... orgs) {
        List<T> ts = query(sql, clazz, orgs);
        return ts.size()>0? ts.get(0): null;
    }

    public static CommonJdbcDao getJdbcDao() {
        return dbConfig.getMainJdbcDao();
    }

    public static CommonHibernateDao getHibernateDao() {
        return dbConfig.getMainHibernateDao();
    }

}
