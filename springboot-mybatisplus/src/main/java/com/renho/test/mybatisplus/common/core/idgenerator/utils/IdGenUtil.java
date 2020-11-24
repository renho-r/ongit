package com.renho.test.mybatisplus.common.core.idgenerator.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.springframework.stereotype.Service;

/**
 * 分布式ID生成工具类
 * 防止不同名的id获取到同一个id的值。
 */

@Service("IdGenUtil")
public class IdGenUtil{

	private final Map<String, IDGenerator> idGeneratorMap = new HashMap<String, IDGenerator>();
	private final ReadWriteLock lock = new ReentrantReadWriteLock(false);

	public long next(Class<?> clazz) {
		return next(clazz.getSimpleName());
	}

	public long next(String seqName) {

   		IDGenerator idGenerator = null;
		lock.readLock().lock();
		try {
			idGenerator = idGeneratorMap.get(seqName);
		} finally {
			lock.readLock().unlock();
		}

		if (idGenerator == null) {
			lock.writeLock().lock();
			try {
				idGenerator = idGeneratorMap.get(seqName);
				if (idGenerator == null) {
					idGenerator = new IDGenerator();
					idGenerator.setSeqName(seqName);
					idGenerator.init(seqName);
					idGeneratorMap.put(seqName, idGenerator);
				}
			} finally {
				lock.writeLock().unlock();
			}
		}
		return idGenerator.next(seqName);
	}

	public List<Object> nextList(String seqName, int listSize){
		IDGenerator idGenerator = null;
		lock.readLock().lock();
		try {
			idGenerator = idGeneratorMap.get(seqName);
		} finally {
			lock.readLock().unlock();
		}
		if (idGenerator == null) {
			lock.writeLock().lock();
			try {
				idGenerator = idGeneratorMap.get(seqName);
				if (idGenerator == null) {
					idGenerator = new IDGenerator();
					idGenerator.setSeqName(seqName);
					idGenerator.init(seqName);
					idGeneratorMap.put(seqName, idGenerator);
				}
			} finally {
				lock.writeLock().unlock();
			}
		}

		return idGenerator.nextList(seqName,listSize);

	}

}
