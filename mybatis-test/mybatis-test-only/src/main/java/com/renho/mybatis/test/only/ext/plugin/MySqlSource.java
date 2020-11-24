package com.renho.mybatis.test.only.ext.plugin;

import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

import java.util.HashMap;

/**
 * @author renho
 * @date 2020/10/29
 */
public class MySqlSource implements SqlSource {

    private Configuration configuration;
    private BoundSql boundSql;

    public MySqlSource(Configuration configuration, BoundSql boundSql) {
        this.configuration = configuration;
        this.boundSql = boundSql;
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
//        System.out.println("getBoundSql");
//        SqlSourceBuilder sqlSourceParser = new SqlSourceBuilder(configuration);
//        SqlSource sqlSource = sqlSourceParser.parse("select * from blog", Object.class, new HashMap<String, Object>(16));
//        return sqlSource.getBoundSql(parameterObject);

        return this.boundSql;
    }
}
