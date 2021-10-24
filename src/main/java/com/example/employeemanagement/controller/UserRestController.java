package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.AppUser;
import com.example.employeemanagement.model.Role;
import com.example.employeemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{username}")
    public ResponseEntity<AppUser> getUser(@PathVariable String username) {
        AppUser user = userService.getUser(username);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user) {
        AppUser savedUser = userService.saveUser(user);
        return ResponseEntity.ok().body(savedUser);
    }

    @PostMapping("/roles")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        Role savedRole = userService.saveRole(role);
        return ResponseEntity.ok().body(savedRole);
    }
}
