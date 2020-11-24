package com.renho.springstarter.test.db;

import com.renho.idgenerator.core.db.entity.po.Sequence;
import com.renho.idgenerator.core.db.mapper.SequenceMapper;
import com.renho.idgenerator.core.db.sequenceoperater.AbstractDbSequenceOperater;
import com.renho.idgenerator.core.db.sequenceoperater.IDbSequenceOperater;

/**
 * @author renho
 * @date 2020/10/27
 */
public class OracleSequenceOperater extends AbstractDbSequenceOperater implements IDbSequenceOperater {

    private SequenceMapper sequenceMapper;

    @Override
    public Sequence init(Sequence sequence) {
        return sequence;
    }

    @Override
    public Sequence next(Sequence sequence) {
        System.out.println("oracle");
        sequence.setCurrent(11111111L);
        sequence.setIncrement(1);
        return sequence;
    }

    public void setSequenceMapper(SequenceMapper sequenceMapper) {
        this.sequenceMapper = sequenceMapper;
    }
}
