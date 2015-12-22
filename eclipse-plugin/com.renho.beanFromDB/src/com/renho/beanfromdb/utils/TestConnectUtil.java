package com.renho.beanfromdb.utils;

import java.sql.Connection;

import com.renho.beanfromdb.modal.DBConfig;

public class TestConnectUtil {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}

	public static boolean testConnect(DBConfig dbConfig) {
		Connection conn = DbUtil.getConnection(dbConfig);
		if(null == conn) {
			return false;
		}
		DbUtil.closeConnection(conn);
		return true;
	}
	
}
