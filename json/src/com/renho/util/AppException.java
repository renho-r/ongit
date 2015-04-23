package com.renho.util;

import java.util.HashMap;
import java.util.Map;

public class AppException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private Map<String, String> msgMap = new HashMap<String, String>();
	
	public AppException(String msg) {
		super(msg);
	}
	
	public void setMsgMap(String key, String value) {
		this.msgMap.put(key, value);
	}
	
	public String getMsgMap(String key) {
		return this.msgMap.get(key);
	}
}
