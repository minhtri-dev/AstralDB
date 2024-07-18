package com.example.warptracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.warptracker.repository.UserRepository;
import com.example.warptracker.service.UserService;
import com.example.warptracker.model.warptrackerdb.User;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping()
    public User getUser(@RequestParam(required = false) Long id,
                        @RequestParam(required = false) Long uid,
                        @RequestParam(required = false) String username,
                        @RequestParam(required = false) String email) {
    if (id != null) {
        return userService.getUserById(id);
    } else if (uid != null) {
        return userService.getUserByUid(uid);
    } else if (username != null) {
        return userService.getUserByUsername(username);
    } else if (email != null) {
        return userService.getUserByEmail(email);
    } else {
        throw new IllegalArgumentException("At least one query parameter (id, uid, username, email) is required");
    }

    // @GetMapping("/{id}")
    // public User getUserById(@PathVariable Long id) {
    //     return userService.getUserById(id);
    // } 

    // @GetMapping("/uid/{uid}")
    // public User getUserByUid(@PathVariable Long uid) {
    //     return userService.getUserById(uid);
    // } 

    // @GetMapping("/username/{username}")
    // public User getUserByUsername(@PathVariable Long username) {
    //     return userService.getUserById(username);
    // } 

    // @GetMapping("/email/{email}")
    // public User getUserByEmail(@PathVariable Long email) {
    //     return userService.getUserById(email);
    // } 
}
}
