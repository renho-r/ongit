package com.renho.e83.section4;

public class Client {
	public static void main(String[] args) {
		System.out.println("The most comfortable season is "
				+ Season.getComfortableSeason());
		System.out.println("The most comfortable season is "
				+ Season.getComfortableSeason());
	}

}

enum Season {
	Spring, Summer, Autumn, Winter;
	// ������ļ���
	public static Season getComfortableSeason() {
		return Spring;
	}
}
