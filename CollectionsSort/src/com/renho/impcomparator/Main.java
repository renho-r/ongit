package com.renho.impcomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<User> list = new ArrayList<User>();
		for(int i=10; i>0; i--) {
			User user = new User();
			user.setId(i);
			user.setName("name:" + i);
			list.add(user);
		}
		Collections.sort(list, new ImpComparator());
		for(User u:list) {
			System.out.println(u.getId());
		}
	}

}
