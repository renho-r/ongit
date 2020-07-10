package com.renho.mybatis.test.only.mapper;

import com.renho.mybatis.test.only.domain.po.Blog;
import org.apache.ibatis.annotations.InsertProvider;

/**
 * @author: renho
 * @since: 1.0.0
 */
public interface BlogMapper {

    Blog selectBlog(int id);

    @InsertProvider(type = BlogSqlFactory.class, method = "insertSql")
    void insert(Blog blog);
}
