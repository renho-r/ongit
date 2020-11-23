package com.renho.idgenerator.core.db.sequenceoperater;

import com.renho.idgenerator.core.db.entity.po.Sequence;

/**
 * @author renho
 * @date 2020/10/26
 */
public interface IDbSequenceOperater {

    /**
     * init
     * @param sequence
     */
    Sequence init(Sequence sequence);

    /**
     * next
     * @param sequence
     * @return
     */
    Sequence next(Sequence sequence);
}
