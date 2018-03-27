package com.renho.system.db.commons.dao;

import javax.sql.DataSource;
import java.util.List;

public interface CommonJdbcDao {

    void setDataSource(DataSource dataSource);

    <T> List<T> query(String sql, Class<T> clazz, Object ... orgs);

}
