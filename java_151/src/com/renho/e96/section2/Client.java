package com.renho.e96.section2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		read(Arrays.asList("A"));
		
	}
	
	public static <E> void read(List<? extends E> list){
		for(E e:list){
			System.out.println(e.getClass());
			//ҵ���߼�����			
		}
	}
	

}
