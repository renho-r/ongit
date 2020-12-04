package com.renho.mybatis.test.only.ext.mapperregistry;

import org.apache.ibatis.binding.MapperRegistry;
import org.apache.ibatis.session.Configuration;

/**
 * @author renho
 * @date 2020/11/27
 */
public class RenhoMapperRegistry extends MapperRegistry {
    public RenhoMapperRegistry(Configuration config) {
        super(config);
    }
}
