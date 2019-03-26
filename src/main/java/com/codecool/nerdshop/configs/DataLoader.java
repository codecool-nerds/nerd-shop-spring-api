package com.codecool.nerdshop.configs;

import com.codecool.nerdshop.products.categories.Category;
import com.codecool.nerdshop.products.categories.CategoryRepository;
import com.codecool.nerdshop.products.Product;
import com.codecool.nerdshop.products.ProductRepository;
import com.codecool.nerdshop.users.AccessLevel;
import com.codecool.nerdshop.users.User;
import com.codecool.nerdshop.users.UserRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DataLoader {
//    @Bean
//    public List<User> loadExampleUsers(UserRepository repository) {
//        List<User> list = new ArrayList<>();
//        User admin = new User("adrian@nerd.pl", "admin123", AccessLevel.ADMIN);
//        repository.save(admin);
//        list.add(admin);
//        User user = new User("karol.trzaska@nerd.pl", "wTibie", AccessLevel.USER);
//        repository.save(user);
//        list.add(user);
//        return list;
//    }
//
//    @Bean
//    public List<Product> loadCategoriesAndProducts(CategoryRepository categoryRepo, ProductRepository productRepo) {
//        List<Product> products = new ArrayList<>();
//        Category mice = new Category("MICE");
//        categoryRepo.save(mice);
//        Category keyboards = new Category("KEYBOARDS");
//        categoryRepo.save(keyboards);
//
//        Product steel = new Product("Rival 300", mice, 150.00, "cool steelseries");
//        Product razer = new Product("Razer 2000", keyboards, 300.00, "random razer keyboard");
//        products.add(steel);
//        products.add(razer);
//        productRepo.saveAll(products);
//        return products;
//    }
}
