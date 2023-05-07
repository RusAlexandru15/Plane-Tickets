package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/** service class for the users */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    /**selects all the users from DB*/
    public List<User> getUsers(){return userRepository.findAll();}


    /**create new user*/
    public User createUser(User user) { return userRepository.save(user);}


    /**updates a user by  id */
    public User updateUserById(Long id, @NotNull User userData){
        User currentUser=userRepository.findById(id).get();

        String nume=userData.getNume();
        String locatie=userData.getLocatie();
        String parola=userData.getParola();

        if(nume!=null){
            currentUser.setNume(nume);
        }
        if(locatie!=null){
            currentUser.setLocatie(locatie);
        }
        if(parola!=null){
            currentUser.setParola(parola);
        }

        userRepository.save(currentUser);
        return currentUser;
    }


    /** delete a user by ID*/
    public String deleteUserByID(Long id) {
        userRepository.deleteById(id);
        return "User " +id + " was deleted";
    }


}
