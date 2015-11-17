package com.renho.beanfromdb.modal;

public class FieldStruct {

	private String name;
	private String type;
	private String path;
	
	public FieldStruct() {}

	public FieldStruct(String name, String type) {
		this(name, type, null);
	}
	
	public FieldStruct(String name, String type, String path) {
		super();
		this.name = name;
		this.type = type;
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
