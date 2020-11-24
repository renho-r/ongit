package com.renho.idgenerator.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author renho
 * @date 2020/10/26
 */
@Data
@ConfigurationProperties(prefix = IdGeneratorProperties.IDGENERATOR_PREFIX)
public class IdGeneratorProperties {

    public static final String IDGENERATOR_PREFIX = "sys.idgenerator";
    public final static String GEN_SEQ_NAME = "GEN_SEQ_NAME";
    private DbIdGeneratorProperties db = new DbIdGeneratorProperties();
    private SnowFlakeIdGeneratorProperties sf = new SnowFlakeIdGeneratorProperties();

    @Data
    class DbIdGeneratorProperties {
        private String sequenceName;
        private Long start;
        private Integer increment;
        private Long max;
    }

    @Data
    class SnowFlakeIdGeneratorProperties {
        private String defaultBit;
        private Long workerIdBits;
        private Long sequenceBits;
        private Long workerId;
        private Boolean dynamicWorkId;
    }
}
