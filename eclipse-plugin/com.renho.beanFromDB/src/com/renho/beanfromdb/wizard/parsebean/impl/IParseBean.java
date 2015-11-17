package com.renho.beanfromdb.wizard.parsebean.impl;

import com.renho.beanfromdb.modal.ClassStruct;

public abstract class IParseBean {

	public ClassStruct parse(ClassStruct classStruct) {
		transTableName(classStruct);
		transColumnType(classStruct);
		transColumnName(classStruct);
		show(classStruct);
		return classStruct;
	}

	protected abstract void transTableName(ClassStruct classStruct);

	protected abstract void show(ClassStruct classStruct);

	protected abstract void transColumnName(ClassStruct classStruct);

	protected abstract void transColumnType(ClassStruct classStruct);
	
}
