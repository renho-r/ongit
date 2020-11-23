package com.renho.idgenerator.core.ext.sf;

import com.renho.idgenerator.core.IIdGenerator;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author renho
 * @date 2020/10/28
 */
public class SnowFlakeIdGenerator implements IIdGenerator {

    private String defaultType;
    private ConcurrentHashMap<String, IIdSfPolicy> idKeepers = new ConcurrentHashMap<>(16);
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(false);

    @Override
    public String get() {
        this.lock.readLock().lock();
        try {
            return this.idKeepers.get(this.defaultType).get();
        } finally {
            this.lock.readLock().unlock();
        }
    }

    @Override
    public String get(String type) {

        this.lock.readLock().lock();
        try {
            if (null==type || "".equals(type)) {
                return this.get();
            }
            IIdSfPolicy sfPolicy = idKeepers.get(type);
            return sfPolicy.get();
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public void put(String policyName, IIdSfPolicy sfPolicy) {
        this.lock.writeLock().lock();
        try {
            this.idKeepers.put(policyName, sfPolicy);
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public void setDefaultType(String defaultType) {
        this.defaultType = defaultType;
    }
}
