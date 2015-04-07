package httpclient.renho;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.params.HttpParams;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) {
		HttpClient client = new HttpClient();
		// 设置代理服务器地址和端口
		// client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port);
		// 使用 GET 方法 ，如果服务器需要通过 HTTPS 连接，那只需要将下面 URL 中的 http 换成 https
		//HttpMethod method = new GetMethod("http://10.1.249.245:6688/NetXpert/dnsbasemanage/dnsProbeTaskAction.do?reqCode=getAgentCfg&taskType=0&probeExecuteIp=10.1.249.245");
		PostMethod method = new PostMethod("http://10.1.249.245:6688/NetXpert/dnsbasemanage/dnsProbeTaskAction.do?reqCode=getAgentCfg");
		
		NameValuePair taskType = new NameValuePair( "taskType" , "0" );
		NameValuePair probeExecuteIp = new NameValuePair( "probeExecuteIp" , "10.1.249.245" );

		method.setRequestBody(new NameValuePair[] {taskType, probeExecuteIp});
		// 使用POST方法
		// HttpMethod method = new PostMethod("http://java.sun.com");
		try {
			client.executeMethod(method);
			// 打印服务器返回的状态
			System.out.println(method.getStatusLine());
			// 打印返回的信息
			System.out.println(method.getResponseBodyAsString());
			// 释放连接
			method.releaseConnection();
			show(method.getResponseBodyAsString());
			
			Map<String, String> map0 = new HashMap<String, String>();
			Map<String, String> map1 = map0;
			System.out.println(map0.equals(map1));
			System.out.println(map0 == map1);
			
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

	public static void show(String cfg) throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		StringReader reader = new StringReader(cfg);
		Document document = db.parse(new InputSource(reader));
		Element element = document.getDocumentElement();
		System.out.println(element.getAttribute("cfgstatus"));
		
		NodeList taskList = element.getElementsByTagName("task");
		
		for (int i = 0; i < taskList.getLength(); i++) {
			Element task = (Element) taskList.item(i);
			System.out.println(task.getAttribute("taskId"));
		}
	}
	
}
