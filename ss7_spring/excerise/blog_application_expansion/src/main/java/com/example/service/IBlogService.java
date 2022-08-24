package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {

    void create(Blog blog);

    Blog findById(Integer id);

    void remove(Integer id);

    Page<Blog> findAllSearchAndPaging(String nameBlog,Pageable pageable);

//    Page<Blog> findAll(String nameBlog,String nameCategory,Pageable pageable);

    Page<Blog> findAllContain(String name,Integer id,Pageable pageable);

//    List<Blog> findAllSearchCategory(Integer id);
}
