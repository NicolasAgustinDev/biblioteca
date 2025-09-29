package com.example.library.dto;

import jakarta.validation.constraints.NotBlank;

public class UserRequestDTO {
    @NotBlank
    private String username;
    @NotBlank private String password;
    private String fullName;
    private String role;
}