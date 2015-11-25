package com.renho.internet.webservice;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import com.renho.internet.webservice.cxf.TrainService;
import com.renho.internet.webservice.cxf.TrainServiceSoap;

public class Client {

	public static void main(String[] args) throws Exception {
		// 这个是用cxf 客户端访问cxf部署的webservice服务
		// 千万记住，访问cxf的webservice必须加上namespace ,否则通不过
		// 现在又另外一个问题，传递过去的参数服务端接收不到
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		org.apache.cxf.endpoint.Client client = dcf.createClient("http://webservice.36wu.com/mapService.asmx?wsdl");
		// url为调用webService的wsdl地址
		QName name = new QName("Yangzhili", "GetLinesInfoByLine");
		// namespace是命名空间，methodName是方法名
		String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "     <facelook>" + "        <condition>"
				+ "            <name>家</name>" + "            <description></description>"
				+ "            <pageno></pageno>" + "            <pagesize></pagesize>" + "        </condition>"
				+ "     </facelook>";
		
		
		System.setProperty("http.proxySet", "true");
		System.setProperty("http.proxyHost", "proxy.asiainfo.com");
		System.setProperty("http.proxyPort", "8080");
		
		// paramvalue为参数值
		Object[] objects = client.invoke(name, xmlStr);
		// 调用web Service//输出调用结果
		System.out.println(objects[0].toString());
		
//		URL wsdlURL = TrainService.WSDL_LOCATION;
//        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
//            File wsdlFile = new File(args[0]);
//            try {
//                if (wsdlFile.exists()) {
//                    wsdlURL = wsdlFile.toURI().toURL();
//                } else {
//                    wsdlURL = new URL(args[0]);
//                }
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//        }
//		
//		TrainService ss = new TrainService(wsdlURL, new QName("Yangzhili", "TrainService"));
//        TrainServiceSoap port = ss.getTrainServiceSoap();  
//        java.lang.String _getJsonDetailInfoByTrainNumber__return = port.getJsonDetailInfoByTrainNumber("1", "2");
//        System.out.println("getJsonDetailInfoByTrainNumber.result=" + _getJsonDetailInfoByTrainNumber__return);
	}

}
