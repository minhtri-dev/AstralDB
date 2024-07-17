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
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null); // Return null if user not found
        // return userOptional.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
}
