package com.renho.beanfromdb.cache;

import java.sql.Connection;
import java.util.TimerTask;

import com.renho.beanfromdb.utils.DbUtil;

public class CloseConnectionTimer extends TimerTask {

	private String key;
	private Connection conn;
	
	public CloseConnectionTimer(String key, Connection conn) {
		super();
		this.key = key;
		this.conn = conn;
	}
	
	@Override
	public void run() {
		DbUtil.closeConnection(conn);
		ConnectionCache.remove(key);
	}

}
