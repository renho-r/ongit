package com.renho.mybatis.test.only.service;

import com.renho.mybatis.test.only.domain.po.Blog;

/**
 * @author: renho
 * @since: 1.0.0
 */
public interface IBlogService {

    Blog selectOne(int id);

    int insert(Blog blog);
}
