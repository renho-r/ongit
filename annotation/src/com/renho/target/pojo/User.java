package com.renho.target.pojo;

import java.sql.Timestamp;

import com.renho.target.TestTarget.CONSTRUCTOR_RENHO;
import com.renho.target.TestTarget.FIELD_RENHO;
import com.renho.target.TestTarget.LOCAL_VARIABLE_RENHO;
import com.renho.target.TestTarget.METHOD_RENHO;
import com.renho.target.TestTarget.TYPE_RENHO;

@TYPE_RENHO(tableName="renho_tableName")
public class User {

	@FIELD_RENHO
	private Integer id;
	private String name;
	private Timestamp updateTime;
	
	@CONSTRUCTOR_RENHO
	public User() {
		
	}

	@METHOD_RENHO
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
	public String show(String appendStr) {
		@LOCAL_VARIABLE_RENHO
		String backStr = id + ":" + name + ":" + ":" + updateTime;
		return backStr + appendStr;
	}
}
