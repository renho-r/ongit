package com.renho.test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class ExTimeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@org.junit.Test
	public void test() throws InterruptedException {
		
		String KEY10S = "key-renho-ex10s";
		
		CacheManager cacheManager = CacheManager.getInstance();
		Cache cache = new Cache("renho", 1, true, false, 10, 20);
		
		cacheManager.addCache(cache);
		cache.put(new Element(KEY10S, "value-renho-ex10s"));
		
		Element element = cache.get(KEY10S);
		assert element != null;
		System.out.println(element.getObjectValue());
		
		TimeUnit.SECONDS.sleep(10);
		element = cache.get(KEY10S);
		Assert.assertNotNull("10sºóÎª¿Õ...", element);
		System.out.println(element.getObjectValue());
	}

}
