package com.renho.guava.basicutilities;

import static com.google.common.base.Preconditions.*;

public class PreconditionsTest {

	public static void main(String[] args) {
		Integer field = checkNotNull(100);
		System.out.println(field);
		
		field = checkNotNull(null);//Exception in thread "main" java.lang.NullPointerException
		System.out.println(field);
	}

}
