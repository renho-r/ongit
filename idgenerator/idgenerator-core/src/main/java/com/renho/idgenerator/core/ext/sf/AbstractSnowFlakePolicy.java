package com.renho.idgenerator.core.ext.sf;

import com.renho.idgenerator.core.ext.sf.config.SnowFlakeConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * copy from org.mohrss.leaf.ext.idgenerator.service.impl.SnowFlowerIDGenImpl
 * Twitter: 1位不用 + 41位时间戳 + 10位workerId(d + w) + 12位序列
 * leaf6:   1位不用 + 48位时间戳 + x位workerId + y位序列  (x + y = 15)
 * 修改:
 *  1. workerId获取方式，可通过IWorkerIdPolicy获取
 *  2. sequence校验，位数不能超过sequenceMask(sequenceBits位)(RANDOM.nextInt)
 * @author renho
 * @date 2020/10/28
 */
public abstract class AbstractSnowFlakePolicy implements IIdSfPolicy {

    private final static Logger logger = LoggerFactory.getLogger(AbstractSnowFlakePolicy.class);
    private static final long WORKER_SEQUENCE = 15L;
    private SnowFlakeConfig snowFlakeConfig;
    protected long workerIdBits;
    protected long sequenceBits;
    protected long workerId;
    /**
     * 最大能够分配的workerid =31
     */
    protected long maxWorkerId;
    protected long workerIdShift;
    protected long timestampLeftShift;
    protected long sequenceMask;
    protected long sequence = 0L;
    protected long lastTimestamp = -1L;
    protected Random random = new Random();

    public AbstractSnowFlakePolicy(SnowFlakeConfig snowFlakeConfig) {
        if (null == snowFlakeConfig) {
            throw new RuntimeException("snowFlakeConfig不能为空!");
        }
        this.snowFlakeConfig = snowFlakeConfig;
        this.workerIdBits = this.snowFlakeConfig.getWorkerIdBits();
        this.sequenceBits = this.snowFlakeConfig.getSequenceBits();
        if (0==this.workerIdBits && this.sequenceBits==0) {
            this.workerIdBits = 5L;
            this.sequenceBits = 10L;
        }
        if (this.workerIdBits<0 || this.workerIdBits>WORKER_SEQUENCE) {
            throw new RuntimeException("workerIdBits 必须在[1 - 14]之间");
        }
        if (this.sequenceBits<0 || this.sequenceBits>WORKER_SEQUENCE) {
            throw new RuntimeException("sequenceBits 必须在[1 - 14]之间");
        }
        if (0 == this.workerIdBits) {
            this.workerIdBits = WORKER_SEQUENCE - this.sequenceBits;
        }
        if (0 == this.sequenceBits) {
            this.sequenceBits = WORKER_SEQUENCE - this.workerIdBits;
        }
        if (WORKER_SEQUENCE != (this.workerIdBits + this.sequenceBits)) {
            throw new RuntimeException("workerIdBits + sequenceBits 必须等于 15 ");
        }
        this.maxWorkerId = -1L ^ (-1L << this.workerIdBits);
        this.workerId = this.snowFlakeConfig.getWorkerId();
        this.workerIdShift = this.sequenceBits;
        this.timestampLeftShift = this.workerIdBits + this.sequenceBits;
        this.sequenceMask = -1L ^ (-1L << this.sequenceBits);
        this.sequence = 0L;
        this.lastTimestamp = -1L;
        logger.info("init snowflake(workerIdBits = {}, sequenceBits = {}) ", this.workerIdBits, this.sequenceBits);
        refresh();
    }

    public synchronized void refresh() {
        if (this.snowFlakeConfig.getDynamicWorkId()) {
            this.workerId = this.snowFlakeConfig.getWorkerIdPolicy().getWorkId(this.snowFlakeConfig);
        }
        if (this.workerId < 0 ) {
            throw new RuntimeException("workerId 不能小于 0 !");
        }
        if (this.workerId > this.maxWorkerId) {
            throw new RuntimeException("workerId 不能超过 " + this.maxWorkerId );
        }
    }

    @Override
    public synchronized String get() {
        long timestamp = timeGen();
        if (timestamp < lastTimestamp) {
            long refusedSeconds = (lastTimestamp - timestamp) / 1000;
            throw new RuntimeException("Clock moved backwards. Refusing for " + refusedSeconds + " seconds");

        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                //seq 为0的时候表示是下一毫秒时间开始对seq做随机
                sequence = random.nextInt(Long.valueOf(sequenceMask).intValue());
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            //如果是新的ms开始
            sequence = random.nextInt(Long.valueOf(sequenceMask).intValue());
        }
        lastTimestamp = timestamp;
        long id = getId();
        return String.valueOf(id);

    }

    /** getId
     * @return
     */
    protected abstract long getId();

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        // 等下一毫秒
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }
}
