package j2setest;

import java.util.HashMap;
import java.util.Map;

public class Main {

	@SuppressWarnings({ "serial" })
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>() {
			{
				//生成 Main$1 extends HashMap
				put("1", "renho");
			}
		};
		if(-1%2 == 0) {
			System.out.println("偶数");
		}else {
			System.out.println("奇数");
		}
	}

}
