package com.renho.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.store.LfuPolicy;

public class LfuTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test() throws InterruptedException {
		CacheManager cacheManager = CacheManager.getInstance();
		Cache cache = new Cache("renho", 5, false, false, 120, 180);
		cacheManager.addCache(cache);
		cache.setMemoryStoreEvictionPolicy(new LfuPolicy());
		for(int i=0; i<10; i++) {
			cache.put(new Element("key_" + i, "value_" + i));
			List<String> keys = cache.getKeys();
			System.out.println("»º´æÊý:" + keys.size());
			TimeUnit.SECONDS.sleep(1);
			cache.get("key_0");
		}
		List<String> keys = cache.getKeys();
		System.out.println("»º´æÊý:" + keys.size());
		keys.forEach(key -> System.out.println(cache.get(key).getObjectValue()));
	}

}
