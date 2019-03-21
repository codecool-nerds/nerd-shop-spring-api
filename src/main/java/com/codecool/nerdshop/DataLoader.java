package com.codecool.nerdshop;

import com.codecool.nerdshop.users.AccessLevel;
import com.codecool.nerdshop.users.User;
import com.codecool.nerdshop.users.UserRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DataLoader {

    @Bean
    public List<User> loadExampleUsers(UserRepository repository) {
        List<User> list = new ArrayList<>();
        User admin = new User("adrian@nerd.pl", "admin123", AccessLevel.ADMIN);
        repository.save(admin);
        list.add(admin);
        User user = new User("karol.trzaska@nerd.pl", "wTibie", AccessLevel.USER);
        repository.save(user);
        list.add(user);
        return list;
    }
}
