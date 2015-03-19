package renho.renho;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import com.demo.HelloWord;

public class ClientTest {
	public static void main(String[] args) throws Exception {
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setServiceClass(HelloWord.class);
		factoryBean.setAddress("http://localhost:8080/webservice/HelloWord");
		HelloWord client = (HelloWord) factoryBean.create();
		System.out.println(client.sayHi("God"));
		System.exit(0);

	}
}