package com.renho.e87.section1;

import java.util.Arrays;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		// ע��summer��Сд
		List<String> params = Arrays.asList("Spring", "summer");
		for (String name : params) {
			// ���ұ���ֵ��name��ͬ��ö����
			Season s = Season.valueOf(name);
			if (s != null) {
				// �и�ö����ʱ�Ĵ���
				System.out.println(s);
			} else {
				// û�и�ö����ʱ���߼�����
				System.out.println("�����ö����");
			}
		}

	}

}

enum Season {
	Spring, Summer, Autumn, Winter;
}
