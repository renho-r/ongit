package com.renho.internet.multithread.threadpool;

import java.util.concurrent.ThreadFactory;

public class ThreadFactoryImpl implements ThreadFactory {

	private String prefix;
	private int threadCount = 1;
	private Integer maxCount;
	
	public ThreadFactoryImpl(String prefix) {
		this.prefix = prefix;
	}
	
	public ThreadFactoryImpl(String prefix, int maxCount) {
		this(prefix);
		this.maxCount = maxCount;
	}
	
	public Thread newThread(Runnable runnable) {
		if(null == maxCount || maxCount < threadCount) {
			return new Thread(runnable, prefix + ":" + threadCount++);
		}
		throw new NewThreadException("ThreadFactoryImpl: new thread exception, threadCount > maxCount");
	}

	public class NewThreadException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		public NewThreadException(String msg) {
			super(msg);
		}
	}
}
