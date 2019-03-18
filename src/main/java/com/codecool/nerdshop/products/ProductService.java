package com.codecool.nerdshop.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Collection<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
