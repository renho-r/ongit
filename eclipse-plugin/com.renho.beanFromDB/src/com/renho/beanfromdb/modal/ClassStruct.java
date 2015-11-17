package com.renho.beanfromdb.modal;

import java.util.List;

public class ClassStruct {
	private String tableName;
	private List<FieldStruct> fields;

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
	
	
}
