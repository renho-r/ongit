package j2setest.jdk8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<String> names = new ArrayList<String>();
		names.add("enho");
		names.add("renho");
		
		Collections.sort(names, (String a, String b) -> {
		    return b.compareTo(a);
		});
		
		for(String s:names) {
			System.out.println(s);
		}
		
		Collections.sort(names, (String a, String b) -> b.compareTo(a));
		
		Collections.sort(names, (a, b) -> b.compareTo(a));
	}

}
