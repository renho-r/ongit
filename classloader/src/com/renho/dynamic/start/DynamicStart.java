package com.renho.dynamic.start;

import com.renho.dynamic.ClassLoader.SuperClassLoader;
import com.renho.dynamic.ClassLoader.impl.GeneralClassLoader;
import com.renho.dynamic.business.businessClass.SuperClass;
import com.renho.dynamic.utils.ClassLoaderUtil;

public class DynamicStart {

	private String path = "E:\\renho\\workspace\\ongit\\classloader";
	private SuperClassLoader scl = null;
	
	public DynamicStart() {}
	
	public DynamicStart(String path, String className) {
		this.path = path;
	}
	
	public void start(String className, String classLoaderId) {
		Class<?> clazz = scl.getClass(className);
		SuperClass business;
		try {
			business = (SuperClass) clazz.newInstance();
			business.setClassLoaderId(classLoaderId);
			business.businessStart();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
	}
	
	public String loadClass(String[] classNames) {
		GeneralClassLoader gcl = new GeneralClassLoader(path);
		for(String className:classNames) {
			try {
				gcl.loadClass(className, 1);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		scl = gcl;
		String classLoaderId = System.nanoTime() + "";
		ClassLoaderUtil.setClassLoder(classLoaderId, gcl);
		return classLoaderId;
	}
	
	public void reStart(String className, String classLoaderId) {
		Class<?> clazz = scl.getClass(className);
		SuperClass business;
		try {
			business = (SuperClass) clazz.newInstance();
			business.setClassLoaderId(classLoaderId);
			business.businessStart();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
	}
	
}
