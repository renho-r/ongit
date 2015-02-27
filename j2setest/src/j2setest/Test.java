package j2setest;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Test {

	@org.junit.Test
	public void test() {
		
		InteNumber in = new InteNumber();
		System.out.println(in.i);
		System.out.println(in.obj.i);
		InteNumber in2 = (InteNumber) in.clone();
		in2.obj.change();
		System.out.println(in.i);
		System.out.println(in.obj.i);
		System.out.println(in2.i);
		System.out.println(in2.obj.i);
		
//		String s1 = new String("abc");
//		String s2 = new String("abc");
//		System.out.println(s1 == s2);
//		System.out.println(s1.equals(s2));
//		System.out.println(s1.hashCode());
//		System.out.println(s2.hashCode());
		
//		TestHash t1 = new TestHash(1);
//		TestHash t2 = new TestHash(1);
//		System.out.println(t1 == t2);
//		System.out.println(t1.equals(t2));
//		System.out.println(t1.hashCode());
//		System.out.println(t2.hashCode());
//		Map map = new HashMap();
//		map.put(t1, "a");
//		System.out.println(map.get(t2));
		
//		Collection c = new LinkedList();
//        c.add("WWW");
//        c.add("JJJ");
//        c.add("KKK");
//        List list = (List)c;
//        int i = 1;
//        System.out.println(c.remove(i));
//        System.out.println(list.remove(i));
//        System.out.println(1);
		
//		InteNumber in = new InteNumber();
//		in.i = 100;
//		int j = 0;
//		change(in, j);
//		System.out.println(in.i);
//		System.out.println(j);
	}
	
	public static void change(InteNumber in, int i) {
		System.out.println(in.i);
		System.out.println(i);
		in.i = 200;
		i = 300;
		in = null;

	}
	
	
	public static void checkThrow(int i) {
		System.out.println("OK");
	}

}
