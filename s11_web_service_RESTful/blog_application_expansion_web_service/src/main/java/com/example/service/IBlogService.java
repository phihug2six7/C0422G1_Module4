package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    void create(Blog blog);

    Blog findById(Integer id);

    void remove(Integer id);

    Page<Blog> findAllSearchAndPaging(String nameBlog, Pageable pageable);

    Page<Blog> findAllByNameContainingAndCategory_CId(String name, Integer id, Pageable pageable);

    List<Blog> findAllByCategory_cId(Integer id);
}
