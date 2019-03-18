package com.codecool.nerdshop.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Collection<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(long id) {
        return productRepository.findById(id).get();
    }

    public Collection<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(Category.valueOf(category));
    }

    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        boolean doesProductHasId = product.getId() != null ? true : false;

        if (doesProductHasId) {
            boolean isProductInDb = productRepository.existsById(product.getId());

            if (!isProductInDb) {
                product.setId(null);
            }
        }

        return productRepository.save(product);
    }
}
