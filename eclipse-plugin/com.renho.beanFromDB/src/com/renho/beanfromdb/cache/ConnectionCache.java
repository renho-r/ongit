package com.renho.beanfromdb.cache;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class ConnectionCache {

	private static Map<String, Connection> connMap = new HashMap<>();
	
	public static Connection getConnection(String dbName) {
		return connMap.get(dbName);
	}
	
	public static void saveConn(String dbName, Connection conn) {
		connMap.put(dbName, conn);
	}
}
