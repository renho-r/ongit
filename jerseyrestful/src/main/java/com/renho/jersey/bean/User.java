package com.renho.jersey.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private Integer id;
	private String name;
	
	public User() {}
	
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
	
}
