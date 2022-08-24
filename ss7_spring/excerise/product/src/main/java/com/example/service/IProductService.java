package com.example.service;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {

    Page<Product> findAll(String pName,Pageable pageable);

    void save(Product product);

    void update(Product product);

    void delete(int id);

    Product findById(int id);

}
