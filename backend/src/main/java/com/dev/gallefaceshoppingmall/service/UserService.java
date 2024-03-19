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

    public void updateUser(String id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));

        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setDob(user.getDob());
        existingUser.setPhone(user.getPhone());
        existingUser.setPassword(user.getPassword());

        userRepository.save(existingUser);
    }

    public void deleteUser(String id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));

        userRepository.delete(existingUser);
    }
}


