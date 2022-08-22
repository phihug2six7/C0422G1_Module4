package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll(String pName);

    void save(Product product);

    void update(Product product);

    void delete(int id);

    Product findById(int id);

}
