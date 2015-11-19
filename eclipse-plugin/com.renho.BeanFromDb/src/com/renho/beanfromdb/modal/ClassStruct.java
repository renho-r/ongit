package com.renho.beanfromdb.modal;

import java.util.List;

public class ClassStruct {
	private String tableName;
	private List<FieldStruct> fields;
	private List<MethodStruct> methods;
	private List<String> importList;

	public ClassStruct(String tableName) {
		this.tableName = tableName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<FieldStruct> getFields() {
		return fields;
	}

	public void setFields(List<FieldStruct> fields) {
		this.fields = fields;
	}

	public List<MethodStruct> getMethods() {
		return methods;
	}

	public void setMethods(List<MethodStruct> methods) {
		this.methods = methods;
	}

	public List<String> getImportList() {
		return importList;
	}

	public void setImportList(List<String> importList) {
		this.importList = importList;
	}
	
}
