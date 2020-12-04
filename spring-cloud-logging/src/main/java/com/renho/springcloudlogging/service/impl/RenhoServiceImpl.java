package com.renho.springcloudlogging.service.impl;

import com.renho.springcloudlogging.service.IRenhoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author renho
 * @date 2020/12/4
 */
@Service
public class RenhoServiceImpl implements IRenhoService {

    private final static Logger logger = LoggerFactory.getLogger(RenhoServiceImpl.class);

    @Override
    public Map<String, Object> logInfo() {
        logger.trace(this.getClass().toGenericString());
        logger.debug(this.getClass().toGenericString());
        logger.info(this.getClass().toGenericString());
        logger.warn(this.getClass().toGenericString());
        logger.error(this.getClass().toGenericString());
        return null;
    }

}
