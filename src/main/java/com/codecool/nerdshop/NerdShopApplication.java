package com.codecool.nerdshop;

import com.codecool.nerdshop.users.AccessLevel;
import com.codecool.nerdshop.users.User;
import com.codecool.nerdshop.users.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class NerdShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(NerdShopApplication.class, args);
    }

}
