package com.renho.mybatis.test.springboot.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: renho
 * @since: 1.0.0
 */

public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> dataSourceKey = ThreadLocal.withInitial(() -> "default");

    public static Map<Object, Object> dataSourcesMap = new ConcurrentHashMap<>(10);

    static {
        dataSourcesMap.put("default", SpringUtils.getBean("defaultDataSource"));
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSource.dataSourceKey.get();
    }

    public static void setDataSource(String dataSource) {
        DynamicDataSource.dataSourceKey.set(dataSource);
        DynamicDataSource dynamicDataSource = (DynamicDataSource) SpringUtils.getBean("dataSource");
        dynamicDataSource.afterPropertiesSet();
    }

    public static String getDataSource() {
        return DynamicDataSource.dataSourceKey.get();
    }

    public static void clear() {
        DynamicDataSource.dataSourceKey.remove();
    }
}
