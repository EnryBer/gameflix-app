package com.example.gameflix.controller;

import com.example.gameflix.dto.UserDTO;
import com.example.gameflix.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/")
public class AuthController {
    private final UserService userService;
    public AuthController(UserService userService) { this.userService = userService; }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO dto) {
        try {
            boolean created = userService.register(dto.getUsername(), dto.getPassword());
            if (created) {
                return ResponseEntity.ok(Map.of("message","User registered successfully"));
            } else {
                return ResponseEntity.status(400).body(Map.of("message","Username already exists"));
            }
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(Map.of("message", ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(Map.of("message","Internal server error"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO dto) {
        boolean ok = userService.login(dto.getUsername(), dto.getPassword());
        if (ok) {
            return ResponseEntity.ok(Map.of("message","Login successful"));
        } else {
            return ResponseEntity.status(401).body(Map.of("message","Invalid username or password"));
        }
    }
}
