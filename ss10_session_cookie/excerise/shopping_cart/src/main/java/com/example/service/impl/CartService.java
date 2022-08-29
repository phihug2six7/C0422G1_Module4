package com.example.service.impl;

import com.example.model.Product;
import com.example.service.ICartService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartService implements ICartService {
    @Override
    public void add(Map<Product, Integer> cart, Product product) {
        if (cart.containsKey(product)) {
            cart.put(product, cart.get(product) + 1);
        } else {
            cart.put(product, 1);
        }
    }

    @Override
    public double countTotal(Map<Product, Integer> cart) {
        double total = 0;
        for (Product product : cart.keySet()) {
            total += product.getPrice() * cart.get(product);
        }
        return total;
    }
}
