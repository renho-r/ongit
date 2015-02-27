package com.renho.algorithm;

public class PI {
	public static void main(String[] args) {
		final int N = 500000000;
		int sum = 0;
		for (int i = 1; i < N; i++) {
			double x = Math.random();
			double y = Math.random();
			if ((x * x + y * y) < 1)
				sum++;
		}
		System.out.println("PI = " + (double) 4 * sum / N);
	}
}
