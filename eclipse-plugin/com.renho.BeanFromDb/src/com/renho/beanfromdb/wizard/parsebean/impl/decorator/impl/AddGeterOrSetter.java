package com.renho.beanfromdb.wizard.parsebean.impl.decorator.impl;

import java.util.ArrayList;
import java.util.List;

import com.renho.beanfromdb.modal.ClassStruct;
import com.renho.beanfromdb.modal.FieldStruct;
import com.renho.beanfromdb.modal.MethodStruct;
import com.renho.beanfromdb.wizard.modal.ExportSetting;
import com.renho.beanfromdb.wizard.parsebean.impl.decorator.TransDecorator;

public class AddGeterOrSetter extends TransDecorator {

	@Override
	public void trans(ClassStruct classStruct, ExportSetting es) {
		super.trans(classStruct, es);
		addGetterOrSetter(classStruct, es);
	}

	private void addGetterOrSetter(ClassStruct classStruct, ExportSetting es) {
		
		List<FieldStruct> fields = classStruct.getFields();
		List<MethodStruct> methods = new ArrayList<>();
		for(FieldStruct fs:fields) {
			MethodStruct getterMs = new MethodStruct(MethodStruct.GETTER);
			getterMs.setBackType(fs.getType());
			getterMs.setMethodName("get" + getTrans(fs.getName()));
			getterMs.setParamType(MethodStruct.NULL);
			getterMs.setParamName(fs.getName());
			methods.add(getterMs);
			
			MethodStruct setterMs = new MethodStruct(MethodStruct.SETTER);
			setterMs.setBackType(MethodStruct.NULL);
			setterMs.setMethodName("set" + getTrans(fs.getName()));
			setterMs.setParamType(fs.getType());
			setterMs.setParamName(fs.getName());
			methods.add(setterMs);
		}
		classStruct.setMethods(methods);
	}

	private String getTrans(String name) {
		boolean first2Upper = false;
		char firstChar = name.charAt(0);
		char secondChar = 0;
		if(name.length() > 1) {
			secondChar = name.charAt(1);
		}
		if(firstChar >= 97 && firstChar <= 122) {
			first2Upper = true;
		}
		if(secondChar >= 65 && secondChar <= 90) {
			first2Upper = false;
		}
		if(first2Upper) {
			name = name.substring(0, 1).toUpperCase() + name.substring(1);
		}
		return name;
	}

}
