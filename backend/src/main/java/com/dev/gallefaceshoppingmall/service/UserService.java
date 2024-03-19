package com.dev.gallefaceshoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.gallefaceshoppingmall.entity.User;
import com.dev.gallefaceshoppingmall.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(String _id, User user) {
        User existingUser = userRepository.findById(_id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + _id));
    
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setDob(user.getDob());
        existingUser.setPhone(user.getPhone());
        existingUser.setPassword(user.getPassword());
    
        userRepository.save(existingUser);
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(String _id) {
        User existingUser = userRepository.findById(_id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + _id));

        userRepository.delete(existingUser);
    }
}

