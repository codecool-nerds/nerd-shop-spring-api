package com.codecool.nerdshop.users;

import com.codecool.nerdshop.users.addresses.Address;
import com.codecool.nerdshop.users.addresses.AddressRepository;
import com.codecool.nerdshop.users.userData.UserData;
import com.codecool.nerdshop.users.userData.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final UserDataRepository userDataRepository;

    @Autowired
    public UserService(UserRepository userRepository, AddressRepository addressRepository, UserDataRepository userDataRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.userDataRepository = userDataRepository;
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User persistUser(User user) {
        Address address = user.getAddress();
        UserData userData = user.getUserData();
        user.setUserData(null);
        user.setAddress(null);
        User newUser = userRepository.save(user);
        address.setUser(newUser);
        address = addressRepository.save(address);
        user.setAddress(address);
        userData.setUser(newUser);
        userData = userDataRepository.save(userData);
        user.setUserData(userData);
        return userRepository.save(user);
    }
}
