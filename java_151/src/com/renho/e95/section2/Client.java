package com.renho.e95.section2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		// �����÷�
		List<String> list1 = ArrayUtils.asList("A", "B");
		// ����Ϊ��
		List<Object> list2 = ArrayUtils.asList();
		// ����Ϊ���ֺ��ַ����Ļ��
		List list3 = ArrayUtils.asList(1, 2, 3.1);
	}

}

class ArrayUtils {
	// ��һ���䳤����ת��Ϊ�б�
	public static <T> List<T> asList(T... t) {
		List<T> list = new ArrayList<T>();
		Collections.addAll(list, t);
		return list;
	}
}
