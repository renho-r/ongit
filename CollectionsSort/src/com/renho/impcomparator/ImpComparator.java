package com.renho.impcomparator;

import java.util.Comparator;

public class ImpComparator implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		return -o1.getId().compareTo(o2.getId());
	}

}
