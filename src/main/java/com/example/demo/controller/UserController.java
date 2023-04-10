package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping("/users")
    public List<User> getUsersControlled(){
        return userService.getUsers();
    }


    @PostMapping("/users/new")
    public User saveUserControlled(@RequestBody User user){return userService.createUser(user);}


}
