package com.springboot.microservice.userservice.controller;

import com.springboot.microservice.userservice.entity.User;
import com.springboot.microservice.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long userId) {
        return userService.getUserById(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long userId) {
        userService.deleteUserById(userId);
    }

    @PutMapping("/")
    public User update(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
