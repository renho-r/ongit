package com.renho.beanfromdb.modal;

public class Table extends DBViewSuperBean {
	
	private String tableName;
	
	public Table(String tableName) {
		this.tableName = tableName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	@Override
	public String getTitle(){
		return tableName;
	}
}
