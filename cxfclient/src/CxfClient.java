package com.asiainfo.nfissuedtask.client;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;

import com.asiainfo.ddos.api.ISyncOrderService;
import com.asiainfo.ddos.api.JAXBException_Exception;
import com.asiainfo.ddos.api.SyncOrderServiceImplService;

public class CxfClient {

	public static void main(String[] args) throws JAXBException_Exception, IOException {
		SyncOrderServiceImplService syncOrderService = new SyncOrderServiceImplService(new URL("http://10.1.69.55:9090/NetXpert/wsservices/syncOrder?wsdl"));
		ISyncOrderService service = syncOrderService.getSyncOrderServiceImplPort();
		System.out.println(service.syncOrder(getXml()));
	}
	
	public static String getXml() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("javaorder.xml", "r");
		byte[] bs = new byte[(int) raf.length()];
		raf.read(bs);
		raf.close();
		return new String(bs, "UTF-8");
	}
}
