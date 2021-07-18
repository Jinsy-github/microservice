package com.springboot.microservice.userservice.service;

import com.springboot.microservice.userservice.entity.User;
import com.springboot.microservice.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser(User user) {

        User user1 = userRepository.findById(user.getId()).get();
        if(Objects.nonNull(user1.getFirstName())){
            user1.setFirstName(user.getFirstName());
        }
        return userRepository.save(user1);
    }
}
