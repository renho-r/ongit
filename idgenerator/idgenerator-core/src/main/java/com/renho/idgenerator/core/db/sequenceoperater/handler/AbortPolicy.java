package com.renho.idgenerator.core.db.sequenceoperater.handler;

import com.renho.idgenerator.core.db.entity.po.Sequence;
import com.renho.idgenerator.core.db.sequenceoperater.ExceedMaxHandler;

/**
 * @author renho
 * @date 2020/10/26
 */
public class AbortPolicy implements ExceedMaxHandler {

    @Override
    public void exceedMax(Sequence sequence) {
        throw new RuntimeException("sequence exceed max ...");
    }
}
