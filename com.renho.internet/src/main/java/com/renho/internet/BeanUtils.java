package com.renho.internet;

import java.util.HashMap;
import java.util.Map;

public class BeanUtils {
	public static <T> T getObjFromParams(Class<T> clazz, String paramStr) {
//		HashMap<String, String> paraMap = new HashMap<String, String>();
		HashMap paraMap = new HashMap();
		return getObjFromMap(clazz, paraMap);
	}
	
//	public static <T, String> T getObjFromMap(Class<T> clazz, Map<String, String> paraMap) {
//		T obj = null;
//		return obj;
//	}
	
	public static <T, String> T getObjFromMap(Class<T> clazz, Map<String, String> paraMap) {
		T obj = null;
		return obj;
	}
}
