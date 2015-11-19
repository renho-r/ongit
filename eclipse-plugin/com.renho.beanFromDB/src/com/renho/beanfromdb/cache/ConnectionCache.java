package com.renho.beanfromdb.cache;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

import com.renho.beanfromdb.controller.BeanFromDbManager;
import com.renho.beanfromdb.modal.DBConfig;
import com.renho.beanfromdb.modal.DBViewSuperBean;
import com.renho.beanfromdb.utils.DbUtil;

public class ConnectionCache {

	private static final long CACHE_TIME = 2 * 60 * 1000;
	private static Map<String, Connection> connMap = new HashMap<>();
	private static Map<String, Timer> closeMap = new HashMap<>();
	
	public static Connection getConnection(String dbName) {
		Connection conn = connMap.get(dbName);
		try {
			if(null == conn || conn.isClosed()) {
				conn = createConnection(dbName);
				connMap.put(dbName, conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Timer timer = closeMap.get(dbName);
		if(null != timer) {
			timer.cancel();
			closeMap.remove(dbName);
		}
		timer = new Timer();
		timer.schedule(new CloseConnectionTimer(dbName, conn), CACHE_TIME);
		closeMap.put(dbName, timer);
		return conn;
	}
	
	public static void saveConn(String dbName, Connection conn) {
		connMap.put(dbName, conn);
		Timer timer = closeMap.get(dbName);
		if(null != timer) {
			timer.cancel();
			closeMap.remove(dbName);
		}
		timer = new Timer();
		timer.schedule(new CloseConnectionTimer(dbName, conn), CACHE_TIME);
		closeMap.put(dbName, timer);
	}
	
	public static void closeAll() {
		for(String key:connMap.keySet()) {
			Connection conn = connMap.get(key);
			if(null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	private static Connection createConnection(String dbName) {
		Collection<DBViewSuperBean> dbViewSuperBeans = BeanFromDbManager.getBeanFromDbManager().getDbViewSuperBeans();
		for(DBViewSuperBean dvsb:dbViewSuperBeans) {
			if(dvsb instanceof DBConfig) {
				DBConfig dbConfig = (DBConfig) dvsb;
				if(dbName.equals(dbConfig.getTitle())) {
					return DbUtil.getConnection(dbConfig); 
				}
			}
		}
		return null;
	}

	public static void close(String dbName) {
		Connection conn = connMap.get(dbName);
		if(null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			connMap.remove(dbName);
		}
		
		Timer timer = closeMap.get(dbName);
		if(null != timer) {
			timer.cancel();
			closeMap.remove(dbName);
		}
	}
	
	public static void close(DBConfig[] items) {
		for(DBConfig dbConfig:items) {
			close(dbConfig.getTitle());
		}
	}
	
	public static void remove(String key) {
		connMap.remove(key);
		closeMap.remove(key);
	}

}
