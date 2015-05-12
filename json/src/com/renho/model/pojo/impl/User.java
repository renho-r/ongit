package com.renho.model.pojo.impl;

import java.sql.Timestamp;
import java.util.Map;

import com.renho.model.pojo.SupperPojo;

public class User implements SupperPojo {
	
	private Integer userId;
	private String userName;
	private Timestamp time;
	
	public User() {}
	
	public User(Integer userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getUserName() {
		return userName;
	}
	
	public void show() {
		System.out.println("userId:" + userId + "----userName:" + userName + "----time:" + time);
	}

	@Override
	public Map<String, String> isMapping() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
