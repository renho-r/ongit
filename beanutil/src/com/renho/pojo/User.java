package com.renho.pojo;

import java.util.Date;

public class User {

	private String id;
	private String name;
	private int age;
	private float fAge;
	private Date date;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getfAge() {
		return fAge;
	}
	public void setfAge(float fAge) {
		this.fAge = fAge;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String toString() {
		return "id:" + this.id + "-name:" + this.name + "-age:" + this.age + "-fAge:" + this.fAge + "-date:" + date;
	}
	
}
