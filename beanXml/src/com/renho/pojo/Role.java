package com.renho.pojo;

import java.io.Serializable;

public class Role implements Serializable{
	
	private static final long serialVersionUID = -559669791222274750L;
	
	private Integer roleId;
	private String roleName;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
