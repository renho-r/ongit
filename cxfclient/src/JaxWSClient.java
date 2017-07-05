package com.asiainfo.nfissuedtask.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.renho.cxfservice.service.IRenhoService;

public class JaxWSClient {

	public static void main(String[] args) throws MalformedURLException {
		URL wsdlURL = new URL("http://10.1.69.55:9090/cxfservice/wsservices/syncOrder?wsdl");
//		URL wsdlURL = new URL("http://127.0.0.1:8080");
		QName serviceQName = new QName("http://api.cxf.renho.com", "RenhoServiceImplService");
		QName portQName = new QName("http://api.cxf.renho.com", "RenhoServiceImplPort");
		Service service = Service.create(wsdlURL, serviceQName);
		IRenhoService renhoService = service.getPort(portQName, IRenhoService.class);
		System.out.println(renhoService.getName("π„÷›"));
	}

}
