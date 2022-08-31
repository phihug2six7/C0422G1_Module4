package com.example.service.impl;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public void create(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(new Blog());
    }

    @Override
    public void remove(Integer id) {
        iBlogRepository.delete(findById(id));
    }


    @Override
    public Page<Blog> findAllSearchAndPaging(String nameBlog, Pageable pageable) {
        return iBlogRepository.findAllByNameContaining(nameBlog, pageable);
    }

    @Override
    public Page<Blog> findAllByNameContainingAndCategory_CId(String name, Integer id, Pageable pageable) {
        return iBlogRepository.findAllByNameContainingAndCategory_cId(name, id, pageable);
    }

    @Override
    public List<Blog> findAllByCategory_cId(Integer id) {
        return iBlogRepository.findAllByCategory_cId(id);
    }
}
