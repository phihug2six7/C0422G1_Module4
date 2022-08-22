package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll(String pName);

    void save(Product product);

    void update(Product product);

    void delete(int id);

    Product findById(int id);


}
