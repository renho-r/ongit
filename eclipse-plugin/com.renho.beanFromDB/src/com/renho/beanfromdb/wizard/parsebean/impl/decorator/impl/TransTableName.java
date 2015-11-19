package com.renho.beanfromdb.wizard.parsebean.impl.decorator.impl;

import com.renho.beanfromdb.modal.ClassStruct;
import com.renho.beanfromdb.wizard.modal.ExportSetting;
import com.renho.beanfromdb.wizard.parsebean.impl.decorator.TransDecorator;

public class TransTableName extends TransDecorator {

	@Override
	public void trans(ClassStruct classStruct, ExportSetting es) {
		super.trans(classStruct, es);
		transTableName(classStruct, es);
	}

	private void transTableName(ClassStruct classStruct, ExportSetting es) {
		
	}

}
