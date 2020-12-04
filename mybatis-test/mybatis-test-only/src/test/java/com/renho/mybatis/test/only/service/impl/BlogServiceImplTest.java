package com.renho.mybatis.test.only.service.impl;

import com.renho.mybatis.test.only.domain.po.Blog;
import com.renho.mybatis.test.only.service.IBlogService;
import com.renho.mybatis.test.only.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class BlogServiceImplTest {

    private static SqlSessionFactory sqlSessionFactory;
    private static IBlogService blogService;

    @BeforeAll
    public static void init() {
//        this.sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactoryFromXml();
        sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        blogService = new BlogServiceImpl(sqlSessionFactory);
    }

    @Test
    public void selectOne() {
        Blog blog = this.blogService.selectOne(1);
        System.out.println(blog);
        blog = this.blogService.selectOne(1);
        System.out.println(blog);
    }

//    @RepeatedTest(3)
    @Test
    public void insert() {
        Blog blog = new Blog();
        blog.setName(UUID.randomUUID().toString().replaceAll("-", ""));
        blog.setDesc("desc: " + blog.getName());
        int id = this.blogService.insert(blog);
        System.out.println(blog);
        blog.setId(null);
        id = this.blogService.insert(blog);
        System.out.println(blog);
        blog.setId(null);
        id = this.blogService.insert(blog);
        System.out.println(blog);
    }
}
