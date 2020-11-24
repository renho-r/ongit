package com.renho.idgenerator.core.ext.sf;

import com.renho.idgenerator.core.ext.sf.config.SnowFlakeConfig;

/**
 * @author renho
 * @date 2020/10/28
 */
public interface IWorkerIdPolicy {

    /**
     * 获取workerId
     * @param snowFlakeConfig
     * @return
     */
    long getWorkId(SnowFlakeConfig snowFlakeConfig);

}
