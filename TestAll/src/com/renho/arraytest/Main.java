/**   
* @Title: Main.java 
* @Package com.renho.arraytest 
* @Description: TODO
* @author renho   
* @date 2013年9月5日 下午4:54:13 
* @version V1.0   
*/
package com.renho.arraytest;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList> all = new ArrayList<ArrayList>();
		ArrayList<String> resultList1 = new ArrayList<String>();
		resultList1.add("renho");
		all.add(resultList1);
		resultList1.clear();
	}

}

