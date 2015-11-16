package com.renho.beanfromdb.modal;


public class DBConfig extends DBViewSuperBean {

	private String name;
	private String description;
	private String url;
	private String user;
	private String password;
	
	public DBConfig() {};
	
	public DBConfig(String name, String description, String url, String user, String password) {
		super();
		this.name = name;
		this.description = description;
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getTitle() {
		return this.name;
	}
}
