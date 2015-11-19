package com.renho.beanfromdb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.renho.beanfromdb.modal.DBConfig;

public class DbUtil {

	public static void close(PreparedStatement pstsm, ResultSet rs) {
		if(null != pstsm) {
			try {
				pstsm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeConnection(Connection conn) {
		if(null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection(DBConfig dbConfig) {
		Connection conn = null;
		try {
			String url = dbConfig.getUrl() + "?user=" + dbConfig.getUser() + "&password=" + dbConfig.getPassword();
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
