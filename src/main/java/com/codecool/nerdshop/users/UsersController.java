package com.codecool.nerdshop.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final  UserDataRepository userDataRepository;

    @Autowired
    public UsersController(UserRepository userRepository, AddressRepository addressRepository, UserDataRepository userDataRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.userDataRepository = userDataRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User createNote(@Valid @RequestBody User user) {
        Address address = user.getAddress();
        address = addressRepository.save(address);
        user.setAddress(address);
        UserData userData = user.getUserData();
        userData = userDataRepository.save(userData);
        user.setUserData(userData);
        return userRepository.save(user);
    }
}
