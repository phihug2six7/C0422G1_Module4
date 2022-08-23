package com.example.service;

import com.example.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void create(Blog blog);

    Blog findById(Integer id);

    void remove(Integer id);
}
