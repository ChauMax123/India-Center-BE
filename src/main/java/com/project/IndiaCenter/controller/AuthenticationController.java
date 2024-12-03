package com.project.IndiaCenter.controller;

import com.project.IndiaCenter.dto.AuthResponse;
import com.project.IndiaCenter.dto.UserLoginRequest;
import com.project.IndiaCenter.dto.UserSignupRequest;
import com.project.IndiaCenter.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody UserSignupRequest request) {
        return authService.signUp(request);
    }

    @PostMapping("/signin")
    public AuthResponse signIn(@RequestBody UserLoginRequest request) {
        return authService.signIn(request);
    }
}
