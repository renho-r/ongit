package com.renho.system.db.commons.dao.impl;

import com.renho.system.db.commons.beans.BeanRowMapper;
import com.renho.system.db.commons.dao.CommonJdbcDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class CommonJdbcDaoImpl extends JdbcDaoSupport implements CommonJdbcDao {

    public <T> List<T> query(String sql, Class<T> clazz, Object... orgs) {
        return this.getJdbcTemplate().query(sql, orgs, new BeanRowMapper(clazz));
    }

}
