package com.renho.beanfromdb.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		String reg = "int\\(\\d+\\).*";
		String src = "int(11)  renho";
		
		Pattern pattern = Pattern.compile(reg);
		System.out.println(src.matches(reg));
//		Matcher matcher = pattern.matcher("int(11)");
//		System.out.println(matcher);
	}

}
