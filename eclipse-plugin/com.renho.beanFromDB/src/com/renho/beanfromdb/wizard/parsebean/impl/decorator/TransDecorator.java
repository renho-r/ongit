package com.renho.beanfromdb.wizard.parsebean.impl.decorator;

import com.renho.beanfromdb.modal.ClassStruct;
import com.renho.beanfromdb.wizard.modal.ExportSetting;
import com.renho.beanfromdb.wizard.parsebean.IParseBean;

public class TransDecorator implements IParseBean{

	private IParseBean parseBean;
	
	@Override
	public void trans(ClassStruct classStruct, ExportSetting es) {
		parseBean.trans(classStruct, es);
	}

	public void setParseBean(IParseBean parseBean) {
		this.parseBean = parseBean;
	}

	@Override
	public void show(ClassStruct classStruct, ExportSetting es) {
		parseBean.show(classStruct, es);
	}

	
}
