package com.renho.test;

import java.util.concurrent.TimeUnit;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class TimeOut {

	public static void main(String[] args) throws InterruptedException {
		
		String KEY10S = "key-renho-ex10s";
		
		CacheManager cacheManager = CacheManager.getInstance();
		Cache cache = new Cache("renho", 2, false, false, 10, 20);
		
		cacheManager.addCache(cache);
		add(cache);
		addx(cache);
		see(cache);
		
		TimeUnit.SECONDS.sleep(10);
		Element element = cache.get(KEY10S);
		
		System.out.println(1111111);
	}
	
	public static void add(String name, Cache cache) {
		cache.put(new Element("key-renho-ex10s", new byte[100 * 1024 * 1024]));
	}
	
	public static void addx(Cache cache) {
		cache.put(new Element("key-renho-ex10ss", new byte[100 * 1024 * 1024]));
	}

	public static void see(Cache cache) {
		Element element = cache.get("key-renho-ex10s");
		byte[] bs = (byte[]) element.getObjectValue();
		System.out.println(1111111);
	}
}
