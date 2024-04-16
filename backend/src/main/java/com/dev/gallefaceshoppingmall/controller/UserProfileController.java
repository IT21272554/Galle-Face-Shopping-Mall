package com.dev.gallefaceshoppingmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.gallefaceshoppingmall.entity.User;
import com.dev.gallefaceshoppingmall.service.UserService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/userprofile")
public class UserProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/get/{_id}")
    public ResponseEntity<?> getUserById(@PathVariable String _id) {
        try {
            User user = userService.getUserById(_id);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User profile not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while retrieving user profile.");
        }
    }

    @PutMapping("/update/{_id}")
    public ResponseEntity<?> updateUserProfile(@RequestBody User user, @PathVariable String _id) {
        user.set_id(_id);
        userService.registerUser(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{_id}")
    public ResponseEntity<?> deleteUserProfile(@PathVariable String _id) {
        try {
            userService.deleteUser(_id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while deleting user profile.");
        }
    }
}
