package renho.renho;

import com.demo.HelloWord;
import com.demo.HelloWordImplService;
import com.renho.Receive;
import com.renho.ReceiveImplService;

public class BasicClient {
	public static void main(String[] args) throws Exception {
		//最基本调用方法
		HelloWordImplService server = new HelloWordImplService();
		HelloWord hello = server.getHelloWordImplPort();
		
		String result = hello.sayHi("East");
		System.out.println(result);
		
		ReceiveImplService receiveImplService = new ReceiveImplService();
		Receive receive = receiveImplService.getReceiveImplPort();
		String receiveStr = receive.sendXML("str");
		System.out.println(receiveStr);
		
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