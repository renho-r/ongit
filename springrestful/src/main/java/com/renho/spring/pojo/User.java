package com.renho.spring.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Integer age;
	
	public Integer getId() {
		return id;
	}
	@XmlElement
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	@XmlElement
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
