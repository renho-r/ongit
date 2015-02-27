/**   
* @Title: Test.java 
* @Package com.renho.generic 
* @Description: TODO
* @author renho   
* @date 2013年9月5日 下午3:55:10 
* @version V1.0   
*/
package com.renho.generic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) throws Exception{
		
		/**
		 * java伪泛型
		 */
		/*List<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(100));
		List testList = list;
		testList.add("renho");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}*/
		/**
		 * 反射
		 */
		List<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(100));
		Method method = ArrayList.class.getDeclaredMethod("add", Object.class);
		method.invoke(list, "renho");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}

