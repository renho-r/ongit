package com.renho.algorithm;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 河内塔
 * @author renho
 */

public class TowersofHanoi {
	
	public static int count = 0;
	public static void main(String[] args) {
		InputStreamReader input = new InputStreamReader(System.in);
		Scanner scanner = new Scanner(input);
		System.out.println("请输入盘子数...");
		int num = scanner.nextInt();
		move(num, "A", "B", "C");
		System.out.println(count + "次");
	}
	
	public static void move(int n, String a, String b, String c) {
		count++;
		if(n == 1) {
			System.out.println("盘 " + n + " 由 " + a + " 移至 " + c);
		}else {
			move(n - 1, a, c, b);
			System.out.println("盘 " + n + " 由 " + a + " 移至 " + c);
			move(n - 1, b, a, c);
		}
	}
}
