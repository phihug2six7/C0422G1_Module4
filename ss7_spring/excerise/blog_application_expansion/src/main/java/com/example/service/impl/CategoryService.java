package com.example.service.impl;

import com.example.model.Category;
import com.example.repository.ICategoryRepository;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Override
    public List<Category> findAllCate() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return iCategoryRepository.findById(id).orElse(new Category());
    }
}
