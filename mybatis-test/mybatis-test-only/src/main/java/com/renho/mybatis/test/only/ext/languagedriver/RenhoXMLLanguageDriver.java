package com.renho.mybatis.test.only.ext.languagedriver;

import com.renho.mybatis.test.only.util.LogUtil;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;

/**
 * @author renho
 * @date 2020/11/27
 */
public class RenhoXMLLanguageDriver extends XMLLanguageDriver {

    @Override
    public SqlSource createSqlSource(Configuration configuration, XNode script, Class<?> parameterType) {
        LogUtil.mark();
        return super.createSqlSource(configuration, script, parameterType);
    }

    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {
        LogUtil.mark();
        return super.createSqlSource(configuration, script, parameterType);
    }
}
