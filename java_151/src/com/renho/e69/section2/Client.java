package com.renho.e69.section2;

import java.util.ArrayList;
import java.util.Vector;

public class Client {
	public static void main(String[] args) {
		ArrayList<String> strs = new ArrayList<String>();
		strs.add("A");

		Vector<String> strs2 = new Vector<String>();
		strs2.add("A");
		System.out.println(strs.equals(strs2));
	}
}
