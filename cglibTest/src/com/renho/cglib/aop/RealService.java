package com.renho.cglib.aop;

import java.util.ArrayList;
import java.util.List;

public class RealService {

	public boolean save(String id) {
		System.out.println("RealService save:" + id);
		return true;
	}

	public List<String> list() {
		return new ArrayList<String>() {
			private static final long serialVersionUID = 436947823444068809L;

			{
				add("renho");
				add("renho list");
			}
		};
	}
	
	public String get() {
		System.out.println("get");
		return "renho";
	}
}
