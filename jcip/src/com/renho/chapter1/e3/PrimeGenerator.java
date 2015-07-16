package com.renho.chapter1.e3;

public class PrimeGenerator extends Thread {

	@Override
	public void run() {
		long number = 1L;
		while(true) {
			if(isPrime(number)) {
				System.out.printf("Number %d is prime\n", number);
			}
			if(interrupted()) {
				System.out.printf("The Prime Generator is Interrupted");
				return;
			}
			number++;
		}
	}
	
	private boolean isPrime(long number) {
		if(number <= 2) {
			return true;
		}
		for(long i=2; i<number; i++) {
			if(0 == (number%2)) {
				return false;
			}
		}
		return true;
	}

}
