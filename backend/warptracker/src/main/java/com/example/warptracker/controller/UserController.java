package com.example.warptracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.warptracker.repository.UserRepository;
import com.example.warptracker.service.UserService;
import com.example.warptracker.model.warptrackerdb.User;

@RestController
@RequestMapping("/v1/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/info/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    } 
    
}
