package com.renho;

import java.util.regex.Pattern;

public class Client {

	public static void main(String[] args) {
		String input = "hi renho";
		String regex = "hi*";
		assert Pattern.matches(regex, input) : "regex:" + regex + "------" + "input" + input;
	}

}
