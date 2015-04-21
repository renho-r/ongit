package com.renho.model.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.renho.model.dao.IUserDAO;
import com.renho.model.pojo.impl.User;

public class UserDAOImpl implements IUserDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int save(User user) {
		String insertSql = "INSERT INTO USERINFO(USERID, USERNAME, TIME) VALUES(?, ?, ?)";
		int count = jdbcTemplate.update(insertSql, new Object[]{user.getUserId(), user.getUserName(), user.getTime()});
		return count;
	}

}
