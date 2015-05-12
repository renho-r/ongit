package com.renho.reflect.pojo;

import java.sql.Timestamp;

public class User {

	private Integer userId;
	private String userName;
	private Timestamp updateTime;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	private String show() {
		System.out.println("--------------->userId:" + userId);
		return userName;
	}
	
}
