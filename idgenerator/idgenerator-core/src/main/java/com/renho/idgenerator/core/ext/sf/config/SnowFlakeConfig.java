package com.renho.idgenerator.core.ext.sf.config;

import com.renho.idgenerator.core.ext.sf.IWorkerIdPolicy;

/**
 * @author renho
 * @date 2020/10/28
 */
public class SnowFlakeConfig {

    private String defaultBit;
    private long workerIdBits;
    private long sequenceBits;
    private long workerId;
    private boolean dynamicWorkId;
    private IWorkerIdPolicy workerIdPolicy;

    public long getWorkerIdBits() {
        return workerIdBits;
    }

    public void setWorkerIdBits(long workerIdBits) {
        this.workerIdBits = workerIdBits;
    }

    public long getSequenceBits() {
        return sequenceBits;
    }

    public void setSequenceBits(long sequenceBits) {
        this.sequenceBits = sequenceBits;
    }

    public long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(long workerId) {
        this.workerId = workerId;
    }

    public boolean getDynamicWorkId() {
        return dynamicWorkId;
    }

    public void setDynamicWorkId(boolean dynamicWorkId) {
        this.dynamicWorkId = dynamicWorkId;
    }

    public IWorkerIdPolicy getWorkerIdPolicy() {
        return workerIdPolicy;
    }

    public void setWorkerIdPolicy(IWorkerIdPolicy workerIdPolicy) {
        this.workerIdPolicy = workerIdPolicy;
    }

    public String getDefaultBit() {
        return defaultBit;
    }

    public void setDefaultBit(String defaultBit) {
        this.defaultBit = defaultBit;
    }
}
