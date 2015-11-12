package com.renho.beanfromdb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.renho.beanfromdb.views.bean.DBConfig;

public class TestConnectUtil {

	public static boolean testConnect(DBConfig dbConfig) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = dbConfig.getUrl() + "?user=" + dbConfig.getUser() + "&password=" + dbConfig.getPassword();
//			String url="jdbc:mysql://localhost:3306/sample_db?user=root&password=your_password";
			Connection con = DriverManager.getConnection(url);
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
}
