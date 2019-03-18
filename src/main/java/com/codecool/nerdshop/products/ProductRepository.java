package com.codecool.nerdshop.products;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Collection<Product> findAll();
    Collection<Product> findByCategory(Category category);
}
