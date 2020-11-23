package com.renho.idgenerator.config;

import com.renho.idgenerator.core.IIdGenerator;
import com.renho.idgenerator.core.ext.sf.IWorkerIdPolicy;
import com.renho.idgenerator.core.ext.sf.SnowFlakeIdGenerator;
import com.renho.idgenerator.core.ext.sf.config.SnowFlakeConfig;
import com.renho.idgenerator.core.ext.sf.idpolicy.SnowFlakePolicy16;
import com.renho.idgenerator.core.ext.sf.idpolicy.SnowFlakePolicy18;
import com.renho.idgenerator.core.ext.sf.workeridpolicy.MacIpWorkerIpPolicy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author renho
 * @date 2020/10/27
 */
@Data
@Configuration
@EnableConfigurationProperties(IdGeneratorProperties.class)
@AutoConfigureAfter(DbIdGeneratorAutoConfiguration.class)
public class SfIdGeneratorAutoConfiguration {

    @Autowired
    private IdGeneratorProperties idGeneratorProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = IdGeneratorProperties.IDGENERATOR_PREFIX + ".sf", name = "enabled", havingValue = "true")
    public IWorkerIdPolicy workerIdPolicy() {
        return new MacIpWorkerIpPolicy();
    }

    @Bean
    @ConditionalOnProperty(prefix = IdGeneratorProperties.IDGENERATOR_PREFIX + ".sf", name = "enabled", havingValue = "true")
    public IIdGenerator snowFlakeIdGenerator(IWorkerIdPolicy workerIdPolicy) {

        SnowFlakeConfig snowFlakeConfig = getSnowFlakeConfig(workerIdPolicy);
        snowFlakeConfig.setWorkerIdPolicy(workerIdPolicy);
        SnowFlakeIdGenerator snowFlakeIdGenerator = new SnowFlakeIdGenerator();
        snowFlakeIdGenerator.put("st", new SnowFlakePolicy16(snowFlakeConfig));
        snowFlakeIdGenerator.put("et", new SnowFlakePolicy18(snowFlakeConfig));
        snowFlakeIdGenerator.setDefaultType(snowFlakeConfig.getDefaultBit());

        return snowFlakeIdGenerator;
    }

    private SnowFlakeConfig getSnowFlakeConfig(IWorkerIdPolicy workerIdPolicy) {
        SnowFlakeConfig snowFlakeConfig = new SnowFlakeConfig();
        // id长度: et(18) st(16)
        String defaultBit = this.idGeneratorProperties.getSf().getDefaultBit();
        if (null==defaultBit || "".equals(defaultBit)) {
            defaultBit = "et";
        }
        snowFlakeConfig.setDefaultBit(defaultBit);
        Long workerIdBits = this.idGeneratorProperties.getSf().getWorkerIdBits();
        if (null == workerIdBits) {
            workerIdBits = 0L;
        }
        snowFlakeConfig.setWorkerIdBits(workerIdBits);
        Long sequenceBits = this.idGeneratorProperties.getSf().getSequenceBits();
        if (null == sequenceBits) {
            sequenceBits = 0L;
        }
        snowFlakeConfig.setSequenceBits(sequenceBits);
        Boolean dynamicWorkId = this.idGeneratorProperties.getSf().getDynamicWorkId();
        if (null == dynamicWorkId) {
            dynamicWorkId = false;
        }
        snowFlakeConfig.setDynamicWorkId(dynamicWorkId);
        // 机器编号，要求全局唯一
        Long workerId = this.idGeneratorProperties.getSf().getWorkerId();
        if (null == workerId) {
            workerId = -1L;
        }
        snowFlakeConfig.setWorkerId(workerId);
        return snowFlakeConfig;
    }
}
