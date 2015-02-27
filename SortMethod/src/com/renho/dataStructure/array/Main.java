package com.renho.dataStructure.array;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Array array = new Array();
		array.setArrayByIndex(5, 55);
		System.out.println(array.find(88));
		array.insert(55);
		for(int i=0; i<array.getIndex(); i++) {
			System.out.println(array.getArrayByIndex(i));
		}
	}
}
