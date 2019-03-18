package com.codecool.nerdshop.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(long id) {
        return productRepository.findById(id).get();
    }

    public Collection<Product> getProductsByCategory(String category) {
        if (category != null) {
            return productRepository.findByCategory(Category.valueOf(category.toUpperCase()));
        }

        return productRepository.findAll();
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

    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }
}
