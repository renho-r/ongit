package com.renho.e28;

import java.util.Scanner;

public class Client {
	public static void main(String[] args) {		
		Scanner input = new Scanner(System.in);
		while(input.hasNextInt()){
			int ii = input.nextInt();
			System.out.println("\n===="+ii+" ������ж�======");
			//����ͨ��new������Integer����
			Integer i =new Integer(ii);
			Integer j = new Integer(ii);
			System.out.println("new�����Ķ���" + (i==j));
			
			//��������תΪװ�����ͺ�Ƚ�
			i=ii;
			j=ii;
			System.out.println("��������ת���Ķ���" + (i==j));
			
			//ͨ����̬��������һ��ʵ��
			i=Integer.valueOf(ii);
			j = Integer.valueOf(ii);
			System.out.println("valueOf�����Ķ���"  + (i==j));			
		}		
	}
}
