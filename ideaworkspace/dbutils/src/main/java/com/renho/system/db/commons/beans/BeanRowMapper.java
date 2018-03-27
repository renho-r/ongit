package com.renho.system.db.commons.beans;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BeanRowMapper<T> implements RowMapper<T> {


    private Class<T> clazz = null;

    public BeanRowMapper(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

}
