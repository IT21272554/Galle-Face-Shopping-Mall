package com.dev.gallefaceshoppingmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
=======
import org.springframework.web.bind.annotation.*;
>>>>>>> fa8fdd2040db713b1a22d50804193541fb83b997

import com.dev.gallefaceshoppingmall.entity.User;
import com.dev.gallefaceshoppingmall.service.UserService;


@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/signup")
public class SignUpController {

    @Autowired
    private UserService userService;

    @PutMapping("/update/{_id}")
    public ResponseEntity<?> putUser(@RequestBody User user, @PathVariable String _id) {
        user.set_id(_id);
        userService.registerUser(user);
        
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while registering the user.");
        }
    }

<<<<<<< HEAD
    

=======
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable String id, @RequestBody User user) {
        try {
            userService.updateUser(id, user);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while updating the user.");
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable String id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while deleting the user.");
        }
    }
    
>>>>>>> fa8fdd2040db713b1a22d50804193541fb83b997
}
