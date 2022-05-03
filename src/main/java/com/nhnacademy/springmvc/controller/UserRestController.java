package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.User;
import com.nhnacademy.springmvc.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    private final UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users/{userId}")
    // public User getUser(@PathVariable("userId") String userId) {
    public ResponseEntity<User> getUser(@PathVariable("userId") String userId) {
        // ResponseEntity.notFound().build();
        return ResponseEntity.ok()
                             .header("X-123", "e43344")
                             .body(userRepository.getUser(userId));
    }
}
