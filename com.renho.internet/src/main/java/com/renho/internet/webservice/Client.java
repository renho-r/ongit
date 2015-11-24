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
//		// �������cxf �ͻ��˷���cxf�����webservice����
//		// ǧ���ס������cxf��webservice�������namespace ,����ͨ����
//		// ����������һ�����⣬���ݹ�ȥ�Ĳ�������˽��ղ���
//		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
//		org.apache.cxf.endpoint.Client client = dcf.createClient("http://webservice.36wu.com/TrainService.asmx?wsdl");
//		// urlΪ����webService��wsdl��ַ
//		QName name = new QName("Yangzhili", "GetJsonDetailInfoByTrainNumber");
//		// namespace�������ռ䣬methodName�Ƿ�����
//		String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "     <facelook>" + "        <condition>"
//				+ "            <name>��</name>" + "            <description></description>"
//				+ "            <pageno></pageno>" + "            <pagesize></pagesize>" + "        </condition>"
//				+ "     </facelook>";
//		// paramvalueΪ����ֵ
//		Object[] objects = client.invoke(name, xmlStr);
//		// ����web Service//������ý��
//		System.out.println(objects[0].toString());
		
		URL wsdlURL = TrainService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
		
		TrainService ss = new TrainService(wsdlURL, SERVICE_NAME);
        TrainServiceSoap port = ss.getTrainServiceSoap();  
	}

}
