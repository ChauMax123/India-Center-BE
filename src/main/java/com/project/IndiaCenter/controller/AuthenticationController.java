package com.project.IndiaCenter.controller;

import com.project.IndiaCenter.dto.AuthResponse;
import com.project.IndiaCenter.dto.SignInRequest;
import com.project.IndiaCenter.dto.SignUpRequest;
import com.project.IndiaCenter.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody @Valid SignUpRequest request) {
        return authService.signUp(request);
    }

    @PostMapping("/signin")
    public AuthResponse signIn(@RequestBody @Valid SignInRequest request) {
        System.out.println("Email: " + request.getEmail());
        System.out.println("Password: " + request.getPassword());
        return authService.signIn(request);
    }
}
