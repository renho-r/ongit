package com.renho.springboothibernate.service;

import com.renho.springboothibernate.entity.Blog;

import java.util.List;

/**
 * @author renho
 * @date 2020/12/9
 */
public interface IBlogService {

    void save(Blog blog);

    List<Blog> query();

    List<Blog> testEnv(Blog blog);

    String getEnv(String envName);
}
