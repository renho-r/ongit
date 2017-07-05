package com.renho.dynamic.ClassLoader;

import com.renho.dynamic.business.businessInterface.SuperInterface;

public interface SuperClassLoader {
	
	public Class<?> loadClass(String name, int i) throws ClassNotFoundException;
	public void addInterfaceMap(String interfaceId, SuperInterface superInterface);
	public void removeInterfaceMap(String interfaceId);
	public Class<?> getClass(String className);
}
