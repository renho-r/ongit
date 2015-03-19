package renho;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.HelloWord;

public final class Clientx {

	private Clientx() {
	}

	public static void main(String args[]) throws Exception {
		// START SNIPPET: client
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "beans.xml" });

		HelloWord client = (HelloWord) context.getBean("client");

		String response = client.sayHi("renho");
		System.out.println("Response: " + response);
		System.exit(0);
		// END SNIPPET: client
	}
}