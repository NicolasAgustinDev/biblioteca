package com.example.library.dto.request;

import jakarta.validation.constraints.NotBlank;

public class UserRequestDTO {
    @NotBlank
    private String username;
    @NotBlank private String password;
    private String fullName;
    private String role;
}