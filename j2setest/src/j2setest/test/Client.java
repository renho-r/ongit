package j2setest.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		String s = "renho";
		AllSuper allSuper = new AllSuper();
		allSuper.exe(new Integer(100));
		allSuper.exe(s);
		
		List<Object> list = new ArrayList<Object>();
		list.add("str1");
		list.add("str2");
		p(list);
		
		List<String> list1 = new ArrayList<String>();
		list1.add("str3");
		list1.add("str4");
		p(list1);
		
		List<MyType> list3 = new ArrayList<MyType>();
		list3.add(new MyType(100));
		list3.add(new MyType(101));
		p(list3);
	}
	
	public static void p(List<?> list) {
		for(Object o:list) {
			System.out.println(o.getClass() + o.toString());
		}
	}

}
