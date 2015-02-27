package com.renho.util;

import java.util.AbstractList;

@SuppressWarnings("unchecked")
public class MyList extends AbstractList implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private int size;
	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean add(Object e){
		int i = 0;
		if(0 == i) {
			throw new RenhoException("renho exception");			
		}
//		return super.add(e);
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}
