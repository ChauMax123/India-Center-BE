package com.project.IndiaCenter.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignupRequest {
    private String name;
    private String email;
    private String password;
    private String role;
}

