package com.renho.idgenerator.core.db.sequenceoperater;

import com.renho.idgenerator.core.db.entity.po.Sequence;

/**
 * @author renho
 * @date 2020/10/26
 */
public interface ExceedMaxHandler {

    /**
     * 超过最大值处理
     * 需要设置current、increment
     * @param sequence
     */
    void exceedMax(Sequence sequence);

}
