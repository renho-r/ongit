package com.renho.mybatis.test.only.mapper;

import com.renho.mybatis.test.only.domain.po.Blog;
import com.renho.mybatis.test.only.ext.sqlfactory.BlogSqlFactory;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @author: renho
 * @since: 1.0.0
 */
public interface BlogMapper {

    @Select("select * from blog where id = #{id}")
    Blog selectBlog(int id);

    Blog selectBlogInXml(int id);

    @InsertProvider(type = BlogSqlFactory.class, method = "insertSql")
    @Options(useGeneratedKeys = true)
    void insert(Blog blog);
}
