package com.renho.springstarter.test.workeridpolicy;

import com.renho.idgenerator.core.ext.IWorkerIdPolicy;
import com.renho.idgenerator.core.ext.config.SnowFlakeConfig;

/**
 * @author renho
 * @date 2020/10/27
 */
public class MyWorkerIdPolicy implements IWorkerIdPolicy {
    @Override
    public long getWorkId(SnowFlakeConfig snowFlakeConfig) {
        return 12;
    }
}
