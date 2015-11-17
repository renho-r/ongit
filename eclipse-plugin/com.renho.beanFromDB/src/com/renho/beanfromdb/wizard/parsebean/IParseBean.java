package com.renho.beanfromdb.wizard.parsebean;

import java.util.List;

import com.renho.beanfromdb.modal.BeanStruct;

public abstract class IParseBean {

	public List<BeanStruct> parse(List<BeanStruct> beans) {
		transColumnType(beans);
		transColumnName(beans);
		show(beans);
		return beans;
	}

	protected abstract void show(List<BeanStruct> beans);

	protected abstract void transColumnName(List<BeanStruct> beans);

	protected abstract void transColumnType(List<BeanStruct> beans);
	
}
