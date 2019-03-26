package com.codecool.nerdshop.products.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public Collection<Category> getCategory(@RequestParam(required = false) String name){
        return categoryService.getCategories(name);
    }


    @PostMapping
    public Category addCategory(@Valid @RequestBody Category category){
        return categoryService.insertCategory(category);
    }
}
