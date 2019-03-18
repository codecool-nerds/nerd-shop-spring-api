package com.codecool.nerdshop.products;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Collection<Product> findAll();
    List<Product> findByProductType(Category category);
}
