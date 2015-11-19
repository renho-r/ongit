package com.renho.beanfromdb.wizard.parsebean.impl.decorator.impl;

import java.util.ArrayList;
import java.util.List;

import com.renho.beanfromdb.modal.ClassStruct;
import com.renho.beanfromdb.modal.FieldStruct;
import com.renho.beanfromdb.wizard.modal.ExportSetting;
import com.renho.beanfromdb.wizard.parsebean.impl.decorator.TransDecorator;

public class AddImport extends TransDecorator {

	@Override
	public void trans(ClassStruct classStruct, ExportSetting es) {
		super.trans(classStruct, es);
		addImport(classStruct, es);
	}

	private void addImport(ClassStruct classStruct, ExportSetting es) {
		
		List<String> importList = new ArrayList<>();
		List<FieldStruct> fields = classStruct.getFields();
		
		for(FieldStruct fs:fields) {
			if(!"java.lang".equals(fs.getPath()) && !importList.contains(fs.getPath())) {
				importList.add(fs.getPath() + "." + fs.getType());
			}
		}
		classStruct.setImportList(importList);
	}
}
