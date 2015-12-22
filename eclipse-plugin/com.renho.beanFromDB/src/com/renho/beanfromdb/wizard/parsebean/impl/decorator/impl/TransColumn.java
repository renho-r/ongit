package com.renho.beanfromdb.wizard.parsebean.impl.decorator.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import com.renho.beanfromdb.modal.ClassStruct;
import com.renho.beanfromdb.modal.FieldStruct;
import com.renho.beanfromdb.wizard.modal.ExportSetting;
import com.renho.beanfromdb.wizard.parsebean.impl.decorator.TransDecorator;
import com.renho.beanfromdb.wizard.parsebean.myproperties.MyProperties;

public class TransColumn extends TransDecorator {

	@Override
	public void trans(ClassStruct classStruct, ExportSetting es) {
		super.trans(classStruct, es);
		transColumn(classStruct, es);
	}
	
	private void transColumn(ClassStruct classStruct, ExportSetting es) {
		Properties prop = new MyProperties();
		InputStream in = getClass().getResourceAsStream("/mysqltype.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<FieldStruct> fields = classStruct.getFields();
		outter:
		for(FieldStruct fs:fields) {
			for(Object key:prop.keySet()) {
				if(fs.getType().matches(key.toString())) {
					String packageClass = prop.getProperty((String) key);
					int index = packageClass.lastIndexOf(".");
					String packagePath = packageClass.substring(0, index);
					String className = packageClass.substring(index + 1);
					fs.setPath(packagePath);
					fs.setType(className);
					continue outter;
				}
			}
			fs.setType("noDefined");
		}
	}

}
