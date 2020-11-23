package com.renho.mybatis.test.only.mapper;

import com.renho.mybatis.test.only.domain.po.Blog;
import com.renho.mybatis.test.only.ext.sqlfactory.BlogSqlFactory;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Options;

/**
 * @author: renho
 * @since: 1.0.0
 */
public interface BlogMapper {

    Blog selectBlog(int id);

    @InsertProvider(type = BlogSqlFactory.class, method = "insertSql")
    @Options(useGeneratedKeys = true)
    void insert(Blog blog);
}
