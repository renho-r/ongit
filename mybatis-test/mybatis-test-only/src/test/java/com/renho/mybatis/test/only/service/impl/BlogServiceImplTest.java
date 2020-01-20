package com.renho.mybatis.test.only.service.impl;

import com.renho.mybatis.test.only.domain.po.Blog;
import com.renho.mybatis.test.only.service.IBlogService;
import com.renho.mybatis.test.only.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class BlogServiceImplTest {

    private SqlSessionFactory sqlSessionFactory;
    private IBlogService blogService;

    @Before
    public void init() {
//        this.sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactoryFromXml();
        this.sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        this.blogService = new BlogServiceImpl(this.sqlSessionFactory);
    }

    @Test
    public void selectOne() {
        Blog blog = this.blogService.selectOne(101);
        System.out.println(blog);
    }

    @Test
    public void insert() {
        Blog blog = new Blog();
        blog.setDesc("renho");
        this.blogService.insert(blog);
        System.out.println(blog);
    }
}
