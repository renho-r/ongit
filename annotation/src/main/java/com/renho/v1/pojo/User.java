package com.renho.v1.pojo;

import java.sql.Timestamp;

import com.renho.v1.TestTarget.CONSTRUCTOR_RENHO;
import com.renho.v1.TestTarget.FIELD_RENHO;
import com.renho.v1.TestTarget.LOCAL_VARIABLE_RENHO;
import com.renho.v1.TestTarget.METHOD_RENHO;
import com.renho.v1.TestTarget.PARAMETER_RENHO;
import com.renho.v1.TestTarget.TYPE_RENHO;

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
	
	public String showParam(@PARAMETER_RENHO String p1, @PARAMETER_RENHO("p2") String p2) {
		@LOCAL_VARIABLE_RENHO
		String backStr = id + ":" + name + ":" + ":" + updateTime;
		return backStr + p1 + ":" + p2;
	}
}
