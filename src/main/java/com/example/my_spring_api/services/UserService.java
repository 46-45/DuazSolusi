package com.example.my_spring_api.services;

import com.example.my_spring_api.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {

    UserDetailsService userDetailsService();
    List<User> getAllUsers();
    User updateUser(Long id, User user);
}
