package com.renho.e95.section3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		// �����÷�
		List<String> list1 = ArrayUtils.asList("A", "B");
		// ����Ϊ��
		List<Integer> list2 = ArrayUtils.<Integer> asList();
		// ����Ϊ���ֺ��ַ����Ļ��
		List<Number> list3 = ArrayUtils.<Number> asList(1, 2, 3.1);

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
