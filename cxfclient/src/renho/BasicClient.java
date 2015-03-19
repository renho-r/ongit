package renho;

import com.demo.HelloWord;
import com.demo.HelloWordImplService;

public class BasicClient {
	public static void main(String[] args) throws Exception {
		//最基本调用方法
		HelloWordImplService server = new HelloWordImplService();
		HelloWord hello = server.getHelloWordImplPort();
		
		String result = hello.sayHi("East");
		System.out.println(result);

//		User user = new User();
//		user.setName("East");
//		System.out.println(hello.sayHiToUser(user));
//
//		System.out.println("All the users are: ");
//		for (IdentifiedUser u : hello.getUsers().getEntry()) {
//			System.out.println(u.getUser().getName());
//		}
	}
}