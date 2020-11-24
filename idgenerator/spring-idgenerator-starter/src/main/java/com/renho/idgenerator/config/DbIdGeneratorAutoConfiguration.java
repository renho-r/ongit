package com.renho.idgenerator.config;

import com.renho.idgenerator.core.IIdGenerator;
import com.renho.idgenerator.core.db.DbIdGenerator;
import com.renho.idgenerator.core.db.config.DbIdGeneratorConfig;
import com.renho.idgenerator.core.db.mapper.SequenceMapper;
import com.renho.idgenerator.core.db.sequenceoperater.IDbSequenceOperater;
import com.renho.idgenerator.core.db.sequenceoperater.operater.MysqlSequenceOperaterImpl;
import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * @author renho
 * @date 2020/10/27
 */
@Data
@Configuration
@ConditionalOnClass(SqlSessionFactory.class)
@EnableConfigurationProperties(IdGeneratorProperties.class)
public class DbIdGeneratorAutoConfiguration {

    @Autowired
    private IdGeneratorProperties idGeneratorProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = IdGeneratorProperties.IDGENERATOR_PREFIX + ".db", name = "enabled", havingValue = "true", matchIfMissing = true)
    public IDbSequenceOperater dbSequenceOperater(SequenceMapper sequenceMapper) {
        MysqlSequenceOperaterImpl mysqlSequenceOperater = new MysqlSequenceOperaterImpl();
        mysqlSequenceOperater.setSequenceMapper(sequenceMapper);
        return mysqlSequenceOperater;
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = IdGeneratorProperties.IDGENERATOR_PREFIX + ".db", name = "enabled", havingValue = "true", matchIfMissing = true)
    public IIdGenerator idGenerator(IDbSequenceOperater dbSequenceOperater) {
        DbIdGeneratorConfig dbIdGeneratorConfig = getDbIdGeneratorConfig();
        DbIdGenerator dbIdGenerator = new DbIdGenerator();
        dbIdGenerator.setDbSequenceOperater(dbSequenceOperater);
        dbIdGenerator.setDbIdGeneratorConfig(dbIdGeneratorConfig);
        return dbIdGenerator;
    }

    private DbIdGeneratorConfig getDbIdGeneratorConfig() {
        DbIdGeneratorConfig dbIdGeneratorConfig = new DbIdGeneratorConfig();
        String seqName = this.idGeneratorProperties.getDb().getSequenceName();
        if (StringUtils.isEmpty(seqName)) {
            seqName = IdGeneratorProperties.GEN_SEQ_NAME;
        }
        dbIdGeneratorConfig.setSequenceName(seqName);
        Long start = this.idGeneratorProperties.getDb().getStart();
        if (null == start) {
            start = 1L;
        }
        dbIdGeneratorConfig.setStart(start);
        Integer increment = this.idGeneratorProperties.getDb().getIncrement();
        if (null == increment) {
            increment = 20;
        }
        dbIdGeneratorConfig.setIncrement(increment);
        Long max = this.idGeneratorProperties.getDb().getMax();
        if (null == max) {
            max = Long.MAX_VALUE;
        }
        dbIdGeneratorConfig.setMax(max);
        if (start >= max) {
            throw new RuntimeException("序列开始值(start)不能大于或等于最大值(max)!");
        }
        return dbIdGeneratorConfig;
    }

}
