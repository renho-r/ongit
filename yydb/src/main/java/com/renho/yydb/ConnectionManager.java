package com.renho.yydb;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;

public class ConnectionManager {
	
	public static void main(String[] args) throws InterruptedException {
		
		long start = System.currentTimeMillis();
		
		HttpHost proxy = new HttpHost("10.1.1.21", 8080);
		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));

		PoolingClientConnectionManager conMgr = new PoolingClientConnectionManager(schemeRegistry);
//		conMgr.setMaxTotal(100);
		HttpClient httpClient = new DefaultHttpClient(conMgr);

		// URIs to perform GETs on
		String urisToGet0 = "http://1.163.com/record/getDuobaoRecord.do?gid=510&period=212231323&pageSize=50&pageNum=";
		String urisToGet1 = "&totalCnt=0&t=1450842816540&token=c4";
		// create a thread for each URI
		
		ExecutorService executor = Executors.newFixedThreadPool(300);
		List<Callable<String>> tasks = new ArrayList<>();
		for(int i=0; i<3000; i++) {
			HttpGet httpget = new HttpGet(urisToGet0 + (i%50 + 1) + urisToGet1);
			httpget.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
			tasks.add(new GetThread(httpClient, httpget, i + 1));
		}
		executor.invokeAll(tasks);
		executor.shutdown();
		long end = System.currentTimeMillis();
		System.out.println("time:" + (end-start));
	}
}
