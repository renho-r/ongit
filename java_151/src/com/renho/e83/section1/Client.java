package com.renho.e83.section1;

public class Client {
	public static void main(String[] args) {

	}

	public void describe(Season s) {
		switch (s) {
		case Summer:
			System.out.println(Season.Summer + " is very hot");
			break;
		case Winter:
			System.out.println(Season.Winter + "is very cold");
			break;
		}
	}
}

enum Season {
	Spring, Summer, Autumn, Winter;
}
