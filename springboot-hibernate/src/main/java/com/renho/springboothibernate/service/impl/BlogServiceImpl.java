package com.renho.springboothibernate.service.impl;

import com.renho.springboothibernate.entity.Blog;
import com.renho.springboothibernate.repository.BaseNativeSqlRepository;
import com.renho.springboothibernate.repository.IBlogRepository;
import com.renho.springboothibernate.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author renho
 * @date 2020/12/9
 */
@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;
    @Autowired
    private BaseNativeSqlRepository baseNativeSqlRepository;

    @Override
    public void save(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public List<Blog> query() {
        return this.baseNativeSqlRepository.query("SELECT * FROM BLOG", Blog.class);
    }

    @Transactional
    @Override
    public List<Blog> testEnv(Blog blog) {
//        String envSql = "SET @BLOG_NAME = ?";
//        baseNativeSqlRepository.setEnv(envSql, blog.getName());
        String insertSql = "INSERT INTO BLOG(NAME, ADDRESS) VALUES(@BLOG_NAME, @BLOG_ADDRESS)";
        this.baseNativeSqlRepository.insertByEnv(insertSql);
        return this.baseNativeSqlRepository.query("SELECT * FROM BLOG", Blog.class);
    }

    @Override
    public String getEnv(String envName) {
        return this.baseNativeSqlRepository.getEnv("SELECT @" + envName);
    }
}
