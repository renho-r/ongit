package com.renho.j2se;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<String> aList = new ArrayList<String>();
		System.out.println(aList.size());
		for(int i=0; i<9; i++) {
			aList.add(i + "");
		}
		System.out.println(aList.size());
		System.out.println(10 >> 1);
		aList.add("9");
		aList.add("10");
	}

}
