package com.renho.hibernatetest;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class Action {

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer actionid;
	private Long ServerID;
	private Integer action;
	private Integer flag;
	private String zonename;
	private Timestamp change_time;
	private String uname;
	private Integer send_flag;
	private Integer return_flag;
	private String view;
	private String file_name;

	public Integer getActionid() {
		return this.actionid;
	}

	public void setActionid(Integer actionid) {
		this.actionid = actionid;
	}

	public Long getServerID() {
		return this.ServerID;
	}

	public void setServerID(Long ServerID) {
		this.ServerID = ServerID;
	}

	public Integer getAction() {
		return this.action;
	}

	public void setAction(Integer action) {
		this.action = action;
	}

	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getZonename() {
		return this.zonename;
	}

	public void setZonename(String zonename) {
		this.zonename = zonename;
	}

	public Timestamp getChange_time() {
		return this.change_time;
	}

	public void setChange_time(Timestamp change_time) {
		this.change_time = change_time;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Integer getSend_flag() {
		return this.send_flag;
	}

	public void setSend_flag(Integer send_flag) {
		this.send_flag = send_flag;
	}

	public Integer getReturn_flag() {
		return this.return_flag;
	}

	public void setReturn_flag(Integer return_flag) {
		this.return_flag = return_flag;
	}

	public String getView() {
		return this.view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getFile_name() {
		return this.file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

}