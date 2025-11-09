package com.example.gameflix.service;

import com.example.gameflix.model.User;
import com.example.gameflix.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean register(String username, String rawPassword) {
        if (username == null || username.trim().isEmpty() || rawPassword == null || rawPassword.isEmpty()) {
            throw new IllegalArgumentException("Username and password must not be empty");
        }

        if (userRepository.existsByUsername(username)) {
            return false; // duplicate
        }

        String hashed = passwordEncoder.encode(rawPassword);
        User user = new User(username, hashed);
        userRepository.save(user);
        return true;
    }

    public boolean login(String username, String rawPassword) {
        Optional<User> maybe = userRepository.findByUsername(username);
        if (maybe.isEmpty()) return false;
        User user = maybe.get();
        return passwordEncoder.matches(rawPassword, user.getPasswordHash());
    }
}

