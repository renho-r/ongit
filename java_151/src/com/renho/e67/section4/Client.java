package com.renho.e67.section4;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;

public class Client {
	public static void main(String[] args) {
		// ѧ������,80��
		int stuNum = 80 * 10000;
		// List���ϣ���¼����ѧ���ķ���
		List<Integer> scores = new LinkedList<Integer>();
		// д�����
		for (int i = 0; i < stuNum; i++) {
			scores.add(new Random().nextInt(150));
		}

		// ��¼��ʼ����ʱ��
		long start = System.currentTimeMillis();
		System.out.println("ƽ�����ǣ�" + average(scores));
		System.out.println("ִ��ʱ�䣺" + (System.currentTimeMillis() - start)
				+ "ms");
	}

	// ����ƽ����
	public static int average(List<Integer> list) {
		int sum = 0;		
		if (list instanceof RandomAccess) {
			//���������ȡ����ʹ���±����
			for (int i = 0, size = list.size(); i < size; i++) {
				sum += list.get(i);
			}
		} else {
			//�����ȡ��ʹ��foreach��ʽ
			for (int i : list) {
				sum += i;
			}
		}
		// ��������������ƽ��ֵ
		return sum / list.size();
	}
}
