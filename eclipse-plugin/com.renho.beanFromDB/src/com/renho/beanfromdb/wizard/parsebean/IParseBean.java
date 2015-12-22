package com.renho.beanfromdb.wizard.parsebean;

import com.renho.beanfromdb.modal.ClassStruct;
import com.renho.beanfromdb.wizard.modal.ExportSetting;

public interface IParseBean {
	public abstract void trans(ClassStruct classStruct, ExportSetting es);
	public abstract void show(ClassStruct classStruct, ExportSetting es);
}
