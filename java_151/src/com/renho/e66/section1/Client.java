package com.renho.e66.section1;

import java.util.Arrays;
import java.util.List;

public class Client {
	// ö�٣�����һ������
	enum Week {
		Sun, Mon, Tue, Wed, Thu, Fri, Sat
	}

	public static void main(String[] args) {
		// ������
		Week[] workDays = { Week.Mon, Week.Tue, Week.Wed, Week.Thu, Week.Fri };
		// ת��Ϊ�б�
		List<Week> list = Arrays.asList(workDays);
		// ��������ҲΪ������
		list.add(Week.Sat);

		/* �����տ�ʼ�ɻ��� */
	}
}
