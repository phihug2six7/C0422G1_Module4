package com.example.service;

import com.example.model.Product;

import java.util.Map;

public interface ICartService {
    void add(Map<Product,Integer> cart,Product product);
    double countTotal(Map<Product,Integer> cart);
}
