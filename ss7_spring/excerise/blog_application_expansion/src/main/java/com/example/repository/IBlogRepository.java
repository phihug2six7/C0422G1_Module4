package com.example.repository;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByNameContaining(String nameBlog, Pageable pageable);

    Page<Blog> findAllByNameContainingAndCategory_cId(String name,Integer id,Pageable pageable );
}
