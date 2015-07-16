package com.renho.chapter2.recipe1;

public class Company implements Runnable {

	private Account account;
	
	public Company(Account account) {
		this.account = account;
	}
	
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			this.account.addAccount(1000);
		}
	}

}
