package com.renho.e24;

import java.util.Scanner;

public class Client {
	// һ����Աӵ�в�Ʒ���������
	public final static int LIMIT = 2000;

	public static void main(String[] args) {
		// ��Ա��ǰӵ�в�Ʒ����
		int cur = 1000;
		Scanner input = new Scanner(System.in);
		System.out.print("��������ҪԤ����������");
		while (input.hasNextInt()) {
			int order = input.nextInt();
			// ��ǰӵ�е���׼�������Ĳ�Ʒ����֮
			if (order > 0 && order + cur <= LIMIT) {
				System.out.println("���Ѿ��ɹ�Ԥ����" + order + "����Ʒ��");
			} else {
				System.out.println("�����޶Ԥ��ʧ�ܣ�");

			}
		}
	}
}
