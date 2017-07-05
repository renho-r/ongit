package com.asiainfo.nfissuedtask.client;

import java.io.IOException;
import java.io.RandomAccessFile;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.asiainfo.nfissuedtask.ws.ISyncOrderService;

public class JavaClient {

	public static void main(String[] args) throws Exception {
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setServiceClass(ISyncOrderService.class);
		factoryBean.setAddress("http://10.1.69.55:9090/NetXpert/wsservices/syncOrder");
		ISyncOrderService client = (ISyncOrderService) factoryBean.create();
		System.out.println(client.syncOrder(getXml()));
	}

	public static String getXml() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("javaorder.xml", "r");
		byte[] bs = new byte[(int) raf.length()];
		raf.read(bs);
		raf.close();
		return new String(bs, "UTF-8");
	}

}
