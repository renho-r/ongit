package com.renho.internet.multithread;

import java.util.HashMap;
import java.util.Map;

public class BeanUtils {
	public static <T> T getObjFromParms(Class<T> clazz, String paramStr) {
		HashMap<String, String> paraMap = new HashMap<String, String>();
//		HashMap paraMap = new HashMap();
		return getObjFromMap(clazz, paraMap);
	}

	public static <T> T getObjFromMap(Class<T> clazz, Map<String, String> paraMap) {
		T obj = null;
		try {
			obj = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
