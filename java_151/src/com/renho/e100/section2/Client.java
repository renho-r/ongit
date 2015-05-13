package com.renho.e100.section2;

import java.util.Arrays;
import java.util.List;

public class Client<T> {

	public static Object[] toArray(List list) {
		// �˴���ǿ������û��Ҫ���ڣ�ֻ��Ϊ�˱�����Դ����Ա�
		Object[] t = (Object[]) new Object[list.size()];
		for (int i = 0, n = list.size(); i < n; i++) {
			t[i] = list.get(i);
		}
		return t;
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList("A", "B");
		for (String str : (String[]) toArray(list)) {
			System.out.println(str);
		}
	}

}
