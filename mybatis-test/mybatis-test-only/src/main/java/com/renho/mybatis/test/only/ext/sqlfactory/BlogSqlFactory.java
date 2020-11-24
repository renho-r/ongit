package com.renho.mybatis.test.only.ext.sqlfactory;

import com.renho.mybatis.test.only.domain.po.Blog;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class BlogSqlFactory {

    public static String insertSql(Blog blog) {
        System.out.println("insertSql");
        return "insert into blog(`name`, `address`, `desc`, `create_time`) values(#{name}, #{address}, #{desc}, #{createTime})";
    }

}
