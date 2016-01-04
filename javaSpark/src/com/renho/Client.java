package com.renho;

public class Client {

	public static void main(String[] args) {
		int n = 100000000;
		int inR = 0;
		for(int i=0; i<n; i++) {
			double x = Math.random();
			double y = Math.random();

			if(x*x + y*y < 1) {
				inR++;
			}
		}
		double pi = 4.0 * inR / n;
		System.out.println(pi);
	}

}
