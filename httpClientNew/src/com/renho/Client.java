package com.renho;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Client {

	public static void main(String[] args) throws Exception {

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(
				"http://localhost:8080/NetXpert/aidns/jsps/zoneconfig/basicconfiguration.jsp");

		httpGet.setHeader("Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		httpGet.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
		httpGet.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 5.1; rv:7.0.1) Gecko/20100101 Firefox/7.0.1)");
		httpGet.setHeader("Accept-Charset", "utf-8, GB2312;q=0.7,*;q=0.7");
		httpGet.setHeader("Host", "localhost:8080");
		httpGet.setHeader("Connection", "Keep-Alive");

		CloseableHttpResponse indexResponse = httpclient.execute(httpGet);
		System.out.println(indexResponse.toString());

		HttpEntity httpEntity = indexResponse.getEntity();
		if (null != httpEntity) {
			InputStream in = httpEntity.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String str = br.readLine();
			while (null != str) {
				System.out.println(str);
				str = br.readLine();
			}
			br.close();
			in.close();
			httpclient.close();
		}
		
	}

}
