package com.renho.e23;


public class Client {
	//������30����/��
	public static final int LIGHT_SPEED = 30 * 10000 * 1000;
	public static void main(String[] args) {
		System.out.println("��Ŀ1�������������䵽������Ҫ1�룬���������͵���ľ���");
		long dis1 = LIGHT_SPEED * 1;
		System.out.println("���������ľ����ǣ�" + dis1 + " ��");
		System.out.println("--------------------------------------------");
		System.out.println("��Ŀ2��̫�������䵽��������Ҫ8���ӣ�����̫��������ľ��롣");
		//����Ҫ����������Χ��ʹ��long��
		long dis2 = LIGHT_SPEED * 60 * 8;
		System.out.println("̫�������ľ����ǣ�" + dis2 + " ��");
	}
}
