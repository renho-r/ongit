package com.renho.dynamic.business.businessClass;

import com.renho.dynamic.ClassLoader.SuperClassLoader;
import com.renho.dynamic.business.businessInterface.SuperInterface;
import com.renho.dynamic.utils.ClassLoaderUtil;

public abstract class SuperClass implements SuperInterface{

	private String classLoaderId;
	private String interfaceId;

	public String getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(String interfaceId) {
		this.interfaceId = interfaceId;
	}

	public String getClassLoaderId() {
		return classLoaderId;
	}

	public void setClassLoaderId(String classLoaderId) {
		this.classLoaderId = classLoaderId;
	}

	@Override
	public void init(String classLoaderId) {
		this.classLoaderId = classLoaderId;
		SuperClassLoader superLoader =  ClassLoaderUtil.getClassLoder(getClassLoaderId());
		superLoader.addInterfaceMap(interfaceId, this);
	}

	@Override
	public void destroy() {
		SuperClassLoader superLoader =  ClassLoaderUtil.getClassLoder(getClassLoaderId());
		superLoader.removeInterfaceMap(interfaceId);
	}
	
	public abstract void businessStart();
	
}
