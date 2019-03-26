package com.codecool.nerdshop.products.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepo;

    @Autowired
    public CategoryService(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category insertCategory(Category category) {
        return categoryRepo.save(category);
    }

    public Collection<Category> getCategories(String name) {
        if (name == null) {
            return (List<Category>) categoryRepo.findAll();
        }
        return Collections.singletonList(categoryRepo.findByName(name));
    }
}
