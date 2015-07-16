package com.renho.chapter2.recipe1;

public class Bank implements Runnable {

	private Account account;
	
	public Bank(Account account) {
		this.account = account;
	}
	
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			this.account.subtractAccount(1000);
		}
	}

}
