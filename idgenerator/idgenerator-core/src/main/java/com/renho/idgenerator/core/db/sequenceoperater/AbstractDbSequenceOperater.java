package com.renho.idgenerator.core.db.sequenceoperater;

import com.renho.idgenerator.core.db.sequenceoperater.handler.AbortPolicy;

/**
 * @author renho
 * @date 2020/10/26
 */
public abstract class AbstractDbSequenceOperater {

    protected ExceedMaxHandler exceedMaxHandler = new AbortPolicy();

    public void setExceedMaxHandler(ExceedMaxHandler exceedMaxHandler) {
        this.exceedMaxHandler = exceedMaxHandler;
    }
}
