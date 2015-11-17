package com.renho.beanfromdb.wizard.parsebean.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.renho.beanfromdb.dialogs.DbConfigShowDialog;
import com.renho.beanfromdb.modal.ClassStruct;
import com.renho.beanfromdb.modal.FieldStruct;
import com.renho.beanfromdb.wizard.modal.ExportSetting;
import com.renho.beanfromdb.wizard.parsebean.myproperties.MyProperties;

public class DefaultParseBeanImpl extends IParseBean {

	@Override
	protected void show(ClassStruct classStruct) {
		final StringBuilder sb = new StringBuilder("public class " + classStruct.getTableName().substring(0, 1).toUpperCase() + classStruct.getTableName().substring(1) + " {\r\n");
		List<FieldStruct> fields = classStruct.getFields();
		for(FieldStruct fs:fields) {
			sb.append("\tprivate").append(" ").append(fs.getType()).append(" ").append(fs.getName()).append(";\r\n");
		}
		sb.append("}");
		Dialog showClassDialog = new DbConfigShowDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell(), sb.toString());
		showClassDialog.open();
	}

	@Override
	protected void transColumnName(ClassStruct classStruct) {

	}

	@Override
	protected void transColumnType(ClassStruct classStruct) {
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

	@Override
	protected void transTableName(ClassStruct classStruct) {
		String tableName = classStruct.getTableName();
	}

}
