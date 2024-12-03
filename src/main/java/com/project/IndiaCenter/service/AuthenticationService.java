package com.project.IndiaCenter.service;

import com.project.IndiaCenter.dto.AuthResponse;
import com.project.IndiaCenter.dto.UserLoginRequest;
import com.project.IndiaCenter.dto.UserSignupRequest;
import com.project.IndiaCenter.entity.Role;
import com.project.IndiaCenter.entity.User;
import com.project.IndiaCenter.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthenticationService(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public String signUp(UserSignupRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.valueOf(request.getRole()));

        userRepository.save(user);
        return "User registered successfully!";
    }

    public AuthResponse signIn(UserLoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtService.generateToken(user.getEmail());
        AuthResponse response = new AuthResponse();
        response.setToken(token);
        response.setRole(user.getRole().getName());

        return response;
    }
}
