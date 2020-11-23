package com.renho.springstarter.test.config;

import com.renho.idgenerator.config.IdGeneratorProperties;
import com.renho.idgenerator.core.IIdGenerator;
import com.renho.idgenerator.core.db.DbIdGenerator;
import com.renho.idgenerator.core.db.config.DbIdGeneratorConfig;
import com.renho.idgenerator.core.db.mapper.SequenceMapper;
import com.renho.idgenerator.core.db.sequenceoperater.IDbSequenceOperater;
import com.renho.idgenerator.core.db.sequenceoperater.operater.MysqlSequenceOperaterImpl;
import com.renho.springstarter.test.db.OracleSequenceOperater;
import com.renho.springstarter.test.workeridpolicy.MyWorkerIdPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * @author renho
 * @date 2020/10/27
 */
@Configuration
//@AutoConfigureAfter(IdGeneratorConfiguration.class)
public class MyConfig {

    @Autowired
    private IdGeneratorProperties idGeneratorProperties;

//    @Bean
//    public IDbSequenceOperater dbSequenceOperater(SequenceMapper sequenceMapper) {
//        OracleSequenceOperater oracleSequenceOperater = new OracleSequenceOperater();
//        oracleSequenceOperater.setSequenceMapper(sequenceMapper);
//        return oracleSequenceOperater;
//    }

//    @Bean
//    public IIdGenerator idGenerator(IDbSequenceOperater dbSequenceOperater) {
//
//        DbIdGeneratorConfig dbIdGeneratorConfig = getDbIdGeneratorConfig();
//        dbIdGeneratorConfig.setSequenceName("Oracle");
//        dbIdGeneratorConfig.setStart(100L);
//        dbIdGeneratorConfig.setIncrement(10);
//        dbIdGeneratorConfig.setMax(123L);
//        DbIdGenerator dbIdGenerator = new DbIdGenerator();
//        dbIdGenerator.setDbSequenceOperater(dbSequenceOperater);
//        dbIdGenerator.setDbIdGeneratorConfig(dbIdGeneratorConfig);
//        return dbIdGenerator;
//    }

//    @Bean
//    public MyWorkerIdPolicy workerIdPolicy12345() {
//        return new MyWorkerIdPolicy();
//    }

    private DbIdGeneratorConfig getDbIdGeneratorConfig() {
        DbIdGeneratorConfig dbIdGeneratorConfig = new DbIdGeneratorConfig();
        return dbIdGeneratorConfig;
    }
}
