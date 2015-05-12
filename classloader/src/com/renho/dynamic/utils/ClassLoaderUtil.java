package com.renho.dynamic.utils;

import java.util.HashMap;
import java.util.Map;

import com.renho.dynamic.ClassLoader.SuperClassLoader;

public class ClassLoaderUtil {

	private static Map<String, SuperClassLoader> classLoaderMap = new HashMap<String, SuperClassLoader>();
	
	public static SuperClassLoader getClassLoder(String classLoaderName) {
		return classLoaderMap.get(classLoaderName);
	}
	
	public static void setClassLoder(String classLoaderNamem, SuperClassLoader classLoader) {
		classLoaderMap.put(classLoaderNamem, classLoader);
	}
}
