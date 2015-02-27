package com.renho.algorithm;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * ������
 * @author renho
 */

public class TowersofHanoi {
	
	public static int count = 0;
	public static void main(String[] args) {
		InputStreamReader input = new InputStreamReader(System.in);
		Scanner scanner = new Scanner(input);
		System.out.println("������������...");
		int num = scanner.nextInt();
		move(num, "A", "B", "C");
		System.out.println(count + "��");
	}
	
	public static void move(int n, String a, String b, String c) {
		count++;
		if(n == 1) {
			System.out.println("�� " + n + " �� " + a + " ���� " + c);
		}else {
			move(n - 1, a, c, b);
			System.out.println("�� " + n + " �� " + a + " ���� " + c);
			move(n - 1, b, a, c);
		}
	}
}
