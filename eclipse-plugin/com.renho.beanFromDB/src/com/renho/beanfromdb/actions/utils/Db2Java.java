package com.renho.beanfromdb.actions.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import com.renho.beanfromdb.modal.BeanStruct;

public class Db2Java {

	private List<BeanStruct> list;
	
	public Db2Java(List<BeanStruct> list) {
		this.list = list;
	}
	
	public List<BeanStruct> tran() {
		Properties prop = new Properties();
		InputStream in = getClass().getResourceAsStream("/mysqltype.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		outter:
		for(BeanStruct bs:list) {
			for(Object key:prop.keySet()) {
				if(bs.getType().matches(key.toString())) {
					String packageClass = prop.getProperty((String) key);
					int index = packageClass.lastIndexOf(".");
					String packagePath = packageClass.substring(0, index);
					String className = packageClass.substring(index + 1);
					bs.setPath(packagePath);
					bs.setType(className);
					continue outter;
				}
			}
			bs.setType("noDefined");
		}
		return this.list;
	}
	
	public List<BeanStruct> getResult() {
		return this.list;
	}
	
}
