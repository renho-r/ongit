package com.renho.mybatis.test.only.mapper;

import com.renho.mybatis.test.only.domain.po.Blog;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class BlogSqlFactory {

    public static String insertSql(Blog blog) {
        System.out.println("insertSql");
        return "insert into Blog(addr) values(#{desc})";
    }

}
