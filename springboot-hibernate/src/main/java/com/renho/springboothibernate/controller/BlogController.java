package com.renho.springboothibernate.controller;

import com.renho.springboothibernate.entity.Blog;
import com.renho.springboothibernate.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author renho
 * @date 2020/12/9
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @PostMapping
    public Blog save(@RequestBody Blog blog) {
        this.blogService.save(blog);
        return blog;
    }

    @GetMapping
    public List<Blog> query() {
        return this.blogService.query();
    }

    @PostMapping("/env")
    public List<Blog> testEnv(@RequestBody Blog blog) {
        return this.blogService.testEnv(blog);
    }

    @GetMapping("/env/{envName}")
    public String query(@PathVariable String envName) {
        return this.blogService.getEnv(envName);
    }

}
