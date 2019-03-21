package com.codecool.nerdshop.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.MediaType;
import java.util.Collection;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Collection<Product> getProductsByCategory(@RequestParam(required = false) String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping(value = "/{id}")
    public Product getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product insertProduct(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProductById(@PathVariable long id) {
        productService.deleteProductById(id);
    }
}
