package com.renho.stackTraceTest;

import java.util.*;

/**
 * 递归显示调用方法信息
 * @author song
 *
 */
public class StackTraceTest {
	public static int factorial(int n) {
		System.out.println("factorial(" + n + "):");
		Throwable t = new Throwable();
		StackTraceElement[] frames = t.getStackTrace();
		for (StackTraceElement f : frames)
			System.out.println(f);
		int r;
		if (n <= 1)
			r = 1;
		else {
			System.out.println(n);
			r = n * factorial(n - 1);
		}
		System.out.println("return " + r);

		return r;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter n:");
		int n = in.nextInt();
		System.out.println(factorial(n));
	}
}
