package com.example.service.impl;

import com.example.model.Category;
import com.example.repository.ICategoryRepository;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public Page<Category> findAllCate(Pageable pageable) {
        return iCategoryRepository.findAll(pageable);
    }

    @Override
    public Category findById(Integer id) {
        return iCategoryRepository.findById(id).orElse(new Category());
    }
}
