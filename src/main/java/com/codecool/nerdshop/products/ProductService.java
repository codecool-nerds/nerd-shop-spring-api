package com.codecool.nerdshop.products;

import com.codecool.nerdshop.products.categories.Category;
import com.codecool.nerdshop.products.categories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product getProductById(long id) {
        return productRepository.findById(id).get();
    }

    public Collection<Product> getProductsByCategory(String categoryName) {
        if (categoryName != null) {
            return productRepository.findByCategory_Name(categoryName);
        }
        return productRepository.findAll();
    }

    public Product insertProduct(Product product) {
        Category category = product.getCategory();
        category = categoryRepository.findByName(category.getName());
        product.setCategory(category);
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        boolean hasId = (product.getId() != null);

        if (hasId) {
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
