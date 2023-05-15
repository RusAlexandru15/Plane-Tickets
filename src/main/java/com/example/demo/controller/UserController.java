package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;


    /** returns all users from the database */
    @GetMapping("/users")
    public List<User> getUsersControlled(){
        return userService.getUsers();
    }

    /** creates a new user with information received from a requestBody */
    @PostMapping("/users/new")
    public User saveUserControlled(@RequestBody User user){return userService.createUser(user);}

    /** modifies the user with the given id having information received from a requestBody */
    @PutMapping("/users/editUser{id}")
    public User updateUserControlled(@PathVariable Long id, @RequestBody User userData){
        return userService.updateUserById(id,userData);
    }

    /** deletes the  user with the given id */
    @DeleteMapping("/users/deleteUser{id}")
    public String deleteUserControlled(@PathVariable Long id){
        return userService.deleteUserByID(id);
    }

}
