package com.example.warptracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.example.warptracker.model.warptrackerdb.User;
import com.example.warptracker.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null); // Return null if user not found
        // return userOptional.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User getUserByUid(Long uid) {
        User user = userRepository.findByHsrUid(uid);
        return user;
    }

    public User getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    public User getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }
}
