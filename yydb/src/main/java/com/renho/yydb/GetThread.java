package com.renho.yydb;

import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class GetThread implements Callable<String> {

	private final HttpClient httpClient;
	private final HttpContext context;
	private final HttpGet httpget;
	private int pageNum;

	public GetThread(HttpClient httpClient, HttpGet httpget, int i) {
//		this.httpClient = httpClient;
		this.httpClient = new DefaultHttpClient();
		this.context = new BasicHttpContext();
		this.httpget = httpget;
		this.pageNum = i;
	}
	
	@Override
	public String call() throws Exception {
		try {
			HttpResponse response = this.httpClient.execute(this.httpget, this.context);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String uri = httpget.getURI().toString();
				String re = "http://([^/]*)\\/.*";
				Pattern p = Pattern.compile(re);
				Matcher m = p.matcher(uri);
				if (m.matches()) {
					File file = new File("d:\\renho\\" + m.group(1) + "_" + pageNum + ".data");
					if (!file.exists()) {
						file.createNewFile();
					}
					FileWriter fw = new FileWriter(file);
					String data = EntityUtils.toString(entity);
//					JSONObject dataJson = JSONObject.fromObject(data);
//					fw.write(dataJson.toString());
					fw.write(data);
					fw.close();
				}
			}
			// ensure the connection gets released to the manager
			EntityUtils.consume(entity);
			httpClient.getConnectionManager().shutdown();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.httpget.abort();			
		}
		return null;
	}
}
