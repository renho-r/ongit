package com.renho.e87.section2;

import java.util.Arrays;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		// ע��summer��Сд
		List<String> params = Arrays.asList("Spring", "summer");
		for (String name : params) {
			// ���ұ���ֵ��name��ͬ��ö����
			try {
				Season s = Season.valueOf(name);
				// �и�ö����ʱ�Ĵ���
				System.out.println(s);
			} catch (Exception e) {
				System.out.println("�����ö����");
			}

		}

	}

}

enum Season {
	Spring, Summer, Autumn, Winter;

	public boolean contains(String _name) {

		Season[] season = values();
		for (Season s : season) {
			if (s.name().equals(_name)) {
				return true;
			}
		}
		return false;

	}
}
