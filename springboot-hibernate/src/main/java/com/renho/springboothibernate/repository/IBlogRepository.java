package com.renho.springboothibernate.repository;

import com.renho.springboothibernate.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author renho
 * @date 2020/12/9
 */
@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
}
