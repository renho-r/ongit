package j2setest.effective.e5;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class Client {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		Set<String> set = map.keySet();
		WeakHashMap<String, String> a;
	}

}
