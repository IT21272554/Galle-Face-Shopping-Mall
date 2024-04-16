package com.dev.gallefaceshoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import com.dev.gallefaceshoppingmall.entity.User;
import com.dev.gallefaceshoppingmall.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /*public void registerUser(User user) {
        userRepository.save(user);
    }*/
    public void registerUser(User user) {
        String hashedPassword = hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
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

    public User getUserById(String _id) {
        return userRepository.findById(_id).orElse(null);
    }

    public User getuserbyemail(String email) {
        return userRepository.findByEmail(email);
    }

    public void deleteUser(String _id) {
        User existingUser = userRepository.findById(_id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + _id));

        userRepository.delete(existingUser);
    }

    //Login data

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password: " + e.getMessage());
        }
    }

    public User loginUser(String email, String password) {
        User user = null;
        user = getuserbyemail(email);
        String pwd =hashPassword(password);
 if (user.getPassword().equals(pwd)){
    System.out.println("***********User Login Successfull!***********");

    return user;    
}
/*System.out.println(pwd);
            System.out.println(user.getPassword());*/
        
return null;
        
    }
    
    /*private boolean passwordMatches(String storedPassword, String providedPassword) {
        // Implement secure password comparison logic using hashing
        // (don't compare plain text passwords!)
        return BCrypt.checkpw(providedPassword, storedPassword);
    }*/
 
}

