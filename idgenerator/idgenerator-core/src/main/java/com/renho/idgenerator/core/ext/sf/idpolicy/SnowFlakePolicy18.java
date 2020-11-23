package com.renho.idgenerator.core.ext.sf.idpolicy;

import com.renho.idgenerator.core.ext.sf.AbstractSnowFlakePolicy;
import com.renho.idgenerator.core.ext.sf.config.SnowFlakeConfig;

/**
 * 16位
 * ((timestamp + twepoch) << timestampLeftShift) | (workerId << workerIdShift) | sequence;
 * timestamp = 8796093022208L
 * twepoch当前时间戳
 * @author renho
 * @date 2020/10/28
 */
public class SnowFlakePolicy18 extends AbstractSnowFlakePolicy {

    private static final long TWEPOCH = 8796093022208L;

    public SnowFlakePolicy18(SnowFlakeConfig snowFlakeConfig) {
        super(snowFlakeConfig);
    }

    @Override
    protected long getId() {
        return ((lastTimestamp + TWEPOCH) << timestampLeftShift) | (workerId << workerIdShift) | sequence;
    }
}
