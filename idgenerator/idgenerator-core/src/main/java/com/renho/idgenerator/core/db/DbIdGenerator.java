package com.renho.idgenerator.core.db;

import com.renho.idgenerator.core.IIdGenerator;
import com.renho.idgenerator.core.db.config.DbIdGeneratorConfig;
import com.renho.idgenerator.core.db.entity.po.Sequence;
import com.renho.idgenerator.core.db.sequenceoperater.IDbSequenceOperater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author renho
 * @date 2020/10/26
 */
public class DbIdGenerator implements IIdGenerator {

    private final static Logger logger = LoggerFactory.getLogger(DbIdGenerator.class);
    private ConcurrentHashMap<String, IdKeeper> idKeepers = new ConcurrentHashMap<>(16);
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(false);
    private DbIdGeneratorConfig dbIdGeneratorConfig;
    private IDbSequenceOperater dbSequenceOperater;

    @Override
    public String get() {
        return get(this.dbIdGeneratorConfig.getSequenceName());
    }

    private IdKeeper initIdKeeper(Sequence sequence) {
        IdKeeper idKeeper;
        this.lock.writeLock().lock();
        try {
            idKeeper = this.idKeepers.get(sequence.getName());
            if (null == idKeeper) {
                idKeeper = new IdKeeper(sequence, this.dbSequenceOperater);
                this.idKeepers.put(sequence.getName(), idKeeper);
            }
        } finally {
            this.lock.writeLock().unlock();
        }
        return idKeeper;
    }

    @Override
    public String get(String seqName) {
        if (null==seqName || "".equals(seqName)) {
            throw new RuntimeException("seqName不能为空!");
        }
        IdKeeper idKeeper = this.idKeepers.get(seqName);
        if (null == idKeeper) {
            idKeeper = initIdKeeper(genericSequence(seqName));
        }
        return String.valueOf(idKeeper.next());
    }

    private Sequence genericSequence(String name) {
        Sequence sequence = new Sequence();
        sequence.setName(name);
        sequence.setStart(this.dbIdGeneratorConfig.getStart());
        sequence.setIncrement(this.dbIdGeneratorConfig.getIncrement());
        sequence.setMax(this.dbIdGeneratorConfig.getMax());
        sequence.setCurrent(sequence.getStart() - 1);
        return sequence;
    }

    public void setDbIdGeneratorConfig(DbIdGeneratorConfig dbIdGeneratorConfig) {
        this.dbIdGeneratorConfig = dbIdGeneratorConfig;
    }

    public void setDbSequenceOperater(IDbSequenceOperater dbSequenceOperater) {
        this.dbSequenceOperater = dbSequenceOperater;
    }
}
