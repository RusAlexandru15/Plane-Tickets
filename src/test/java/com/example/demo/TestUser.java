package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import com.example.demo.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TestUser {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    User user1;
    User user2;
    private List<User> userList;

    /** metoda de setup :se va apela inaintea fiecarui test  */
    @BeforeEach
    public void setUp() {
        user1 = new User(1L, "alex", "londra", "1234");
        user2 = new User(2L, "mircea", "targoviste", "0000");

        userList=new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
    }

    /** metoda de test afisarea user-ilor */
    @Test
    public void testGetUsers() {
        when(userRepository.findAll()).thenReturn(userList);
        List<User> currentUsers = userService.getUsers();

        int actualResult=currentUsers.size();
        int expectedResult=2;
        assertEquals(expectedResult, actualResult);
    }


    /** metoda de test pentru creearea unui user nou */
    @Test
    public void testNewUser(){
        User newUser=new User(3L, "aurel", "berlin", "7777");

        when(userRepository.save(newUser)).thenReturn(newUser);


        User addedUser= userService.createUser(newUser);

        Assertions.assertNotNull(addedUser);

        Assertions.assertEquals(3, addedUser.getIdClient());
        Assertions.assertEquals("aurel", addedUser.getNume());
        Assertions.assertEquals("berlin",  addedUser.getLocatie());
        Assertions.assertEquals("7777",  addedUser.getParola());
    }

    /** metoda de test pentru actualizarea unui user (nume + parola)  */
    @Test
    public void testUpdateUserV1(){
        User userData=new User(1L, "alexandru", null, "4321");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));

        User currentUser=userService.updateUserById(1L,userData);

        Assertions.assertNotNull(currentUser.getLocatie());
        Assertions.assertEquals("alexandru",  currentUser.getNume());
        Assertions.assertEquals("4321",  currentUser.getParola());
    }


    /** metoda de test pentru actualizarea unui user (nume + locatie)  */
    @Test
    public void testUpdateUserV2(){
        User userData=new User(1L, "alexandru", "timisoara", null);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));

        User currentUser=userService.updateUserById(1L,userData);

        Assertions.assertNotNull(currentUser.getLocatie());
        Assertions.assertEquals("alexandru",  currentUser.getNume());
        Assertions.assertEquals("timisoara",  currentUser.getLocatie());
    }

    /** metoda de test pentru stergerea unui user dupa ID*/
    @Test
    public void testDeleteUser(){

        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(user1));
        userService.deleteUserByID(1L);
        verify(userRepository, times(1)).deleteById(1L);
    }

}
