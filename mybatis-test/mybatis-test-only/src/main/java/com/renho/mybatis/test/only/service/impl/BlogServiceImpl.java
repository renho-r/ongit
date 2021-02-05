package com.renho.mybatis.test.only.service.impl;

import com.renho.mybatis.test.only.domain.po.Blog;
import com.renho.mybatis.test.only.mapper.BlogMapper;
import com.renho.mybatis.test.only.service.IBlogService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author: renho
 * @since: 1.0.0
 */

public class BlogServiceImpl implements IBlogService {

    private SqlSessionFactory sqlSessionFactory;

    public BlogServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Blog selectOne(int id) {
        Blog blog;
        try (SqlSession session = this.sqlSessionFactory.openSession()) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            blog = mapper.selectBlog(id);
    //        Blog blog = session.selectOne("com.renho.mybatis.test.only.mapper.BlogMapper.selectBlog", id);
        }
        return blog;
    }

    @Override
    public int insert(Blog blog) {
        try (SqlSession session = this.sqlSessionFactory.openSession(true)) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            blog.setCreateTime(System.currentTimeMillis());
            mapper.insert(blog);
        }
        return blog.getId();
    }

}