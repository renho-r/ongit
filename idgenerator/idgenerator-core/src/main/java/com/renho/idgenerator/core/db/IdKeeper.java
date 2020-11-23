package com.renho.idgenerator.core.db;

import com.renho.idgenerator.core.db.entity.po.Sequence;
import com.renho.idgenerator.core.db.sequenceoperater.IDbSequenceOperater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author renho
 * @date 2020/10/26
 */
public class IdKeeper {

    private final static Logger logger = LoggerFactory.getLogger(IdKeeper.class);

    private Sequence sequence;
    private IDbSequenceOperater dbSequenceOperater;

    private long currentOffset;
    private long maxOffset;

    public IdKeeper(Sequence sequence, IDbSequenceOperater dbSequenceOperater) {
        this.sequence = sequence;
        this.dbSequenceOperater = dbSequenceOperater;
        this.init();
    }

    public synchronized long next() {
        if(this.currentOffset >= this.maxOffset){
            if (logger.isDebugEnabled()) {
                logger.debug("over maxOffset, refresh(): {}", sequence.toString());
            }
            refresh();
        }
        return ++this.currentOffset;
    }

    private void init() {
        this.sequence = this.dbSequenceOperater.init(this.sequence);
        this.maxOffset = this.sequence.getCurrent();
        this.currentOffset = this.maxOffset;
        logger.info("IdKeeper init done: {}", this.toString());
    }

    private void refresh() {
        this.sequence = this.dbSequenceOperater.next(sequence);
        this.maxOffset = this.sequence.getCurrent();
        this.currentOffset = this.sequence.getCurrent() - this.sequence.getIncrement();
    }
}
