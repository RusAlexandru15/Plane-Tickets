package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    /**selects all the users from DB*/
    public List<User> getUsers(){return userRepository.findAll();}


    /**create new user*/
    public User createUser(User user) { return userRepository.save(user);}

}
