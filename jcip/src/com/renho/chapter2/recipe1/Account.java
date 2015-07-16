package com.renho.chapter2.recipe1;

public class Account {

	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public synchronized void addAccount(double amount) {
		double temp = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		temp += amount;
		balance = temp;
	}
	
	public synchronized void subtractAccount(double amount) {
		double temp = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		temp -= amount;
		balance = temp;
	}
}
