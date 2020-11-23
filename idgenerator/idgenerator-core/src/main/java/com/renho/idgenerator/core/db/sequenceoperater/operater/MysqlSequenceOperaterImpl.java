package com.renho.idgenerator.core.db.sequenceoperater.operater;

import com.renho.idgenerator.core.db.entity.po.Sequence;
import com.renho.idgenerator.core.db.mapper.SequenceMapper;
import com.renho.idgenerator.core.db.sequenceoperater.AbstractDbSequenceOperater;
import com.renho.idgenerator.core.db.sequenceoperater.IDbSequenceOperater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author renho
 * @date 2020/10/26
 */
@Transactional(propagation= Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public class MysqlSequenceOperaterImpl extends AbstractDbSequenceOperater implements IDbSequenceOperater {

    private boolean tableAuto = false;
    private SequenceMapper sequenceMapper;
    private final static Logger logger = LoggerFactory.getLogger(MysqlSequenceOperaterImpl.class);

    @Override
    public Sequence init(Sequence sequence) {
        String seqName = sequence.getName();
        Sequence dbSequence = null;
        try {
            dbSequence = this.sequenceMapper.selectByName(seqName);
        } catch (RuntimeException e) {
            createTable(sequence, e);
        }
        if (null == dbSequence) {
            if (logger.isDebugEnabled()) {
                logger.debug("create db sequence: {}", sequence.toString());
            }
            this.sequenceMapper.insertSequence(sequence);
            dbSequence = this.sequenceMapper.selectByName(seqName);
        }
        return dbSequence;
    }

    private void createTable(Sequence sequence, RuntimeException e) {
        if (this.tableAuto) {
            this.sequenceMapper.createTable(sequence);
        } else {
            throw e;
        }
    }

    @Override
    public Sequence next(Sequence sequence) {
        if (logger.isDebugEnabled()) {
            logger.debug("get next id from db param: {}", sequence.toString());
        }
        String seqName = sequence.getName();
        Sequence dbSequence = this.sequenceMapper.selectByName(seqName);
        processByCurAndIncr(dbSequence);
        return dbSequence;
    }

    private void adjustIncrement(Sequence sequence, Integer memIncrement) {
        sequence.setIncrement(memIncrement);
    }

    private void processByCurAndIncr(Sequence dbSequence) {
        //正常情况
        Long nextValue = dbSequence.getCurrent() + dbSequence.getIncrement();
        if (nextValue <= dbSequence.getMax()) {
            dbSequence.setCurrent(nextValue);
            Integer memIncrement = dbSequence.getIncrement();
            adjustIncrement(dbSequence, memIncrement);
            this.sequenceMapper.updateCurrent(dbSequence);
            if (logger.isDebugEnabled()) {
                logger.debug("get next id from db after: {}", dbSequence.toString());
            }
            return;
        }
        //未到达最大，但不够一个increment
        nextValue = dbSequence.getMax();
        if (nextValue > dbSequence.getCurrent()) {
            Integer memIncrement = Long.valueOf(nextValue - dbSequence.getCurrent()).intValue();
            adjustIncrement(dbSequence, memIncrement);
            dbSequence.setCurrent(nextValue);
            this.sequenceMapper.updateCurrent(dbSequence);
            if (logger.isDebugEnabled()) {
                logger.debug("get next id from db after: {}", dbSequence.toString());
            }
            return;
        }
        //超过最大，不存库
        this.exceedMaxHandler.exceedMax(dbSequence);
        Integer memIncrement = dbSequence.getIncrement();
        adjustIncrement(dbSequence, memIncrement);
    }

    public void setSequenceMapper(SequenceMapper sequenceMapper) {
        this.sequenceMapper = sequenceMapper;
    }

    public void setTableAuto(boolean tableAuto) {
        this.tableAuto = tableAuto;
    }
}
