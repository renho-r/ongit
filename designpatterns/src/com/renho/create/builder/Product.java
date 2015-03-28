package com.renho.create.builder;

import java.util.ArrayList;
import java.util.List;

public class Product {

	private List<String> parts = new ArrayList<String>();
	
	public void add(String part) {
		this.parts.add(part);
	}
	
	public void show() {
		for(String s:parts) {
			System.out.println(s);
		}
	}
}
