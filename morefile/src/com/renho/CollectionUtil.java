package com.renho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * �����˵1.7�����õ���1.6
 * @author renho
 *
 */
public class CollectionUtil {

	private CollectionUtil() throws Exception {
		throw new Exception("����ʵ����!");
	}
	
	public static <T> List<T> newArrayList() {
		return new ArrayList<T>();
	}
	
	public static <T> List<T> newArrayList(int length) {
		return new ArrayList<T>(length);
	}
	
	public static <K, V> Map<K, V> newHashMap() {
		return new HashMap<K, V>();
	}
}
