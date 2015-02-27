package com.renho.algorithm;
/**
 * 费式数列
 * @author renho
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
		int[] fib = new int[20];
		fib[0] = 0;
		fib[1] = 1;
		for(int i=2; i<20; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		for(int i:fib) {
			System.out.print(i + " ");
		}
	}
}
