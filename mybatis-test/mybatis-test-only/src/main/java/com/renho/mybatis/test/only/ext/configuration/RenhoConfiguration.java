package com.renho.mybatis.test.only.ext.configuration;

import com.renho.mybatis.test.only.ext.languagedriver.RenhoXMLLanguageDriver;
import com.renho.mybatis.test.only.ext.mapperregistry.RenhoMapperRegistry;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;

/**
 * @author renho
 * @date 2020/11/27
 */
public class RenhoConfiguration extends Configuration {

    public RenhoConfiguration(Environment environment) {
        super(environment);
        mapperRegistry = new RenhoMapperRegistry(this);

        languageRegistry.setDefaultDriverClass(RenhoXMLLanguageDriver.class);
    }
}
