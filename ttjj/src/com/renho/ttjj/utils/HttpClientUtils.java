package com.renho.ttjj.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientUtils {
	
	public static String getJjInfo(String url) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse indexResponse = httpclient.execute(httpGet);

		HttpEntity httpEntity = indexResponse.getEntity();
		StringBuffer sb = new StringBuffer();
		if (null != httpEntity) {
			InputStream in = httpEntity.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String str = br.readLine();
			while (null != str) {
				sb.append(str);
				str = br.readLine();
			}
			br.close();
			in.close();
			httpclient.close();
		}
		return sb.toString();
	}
}
