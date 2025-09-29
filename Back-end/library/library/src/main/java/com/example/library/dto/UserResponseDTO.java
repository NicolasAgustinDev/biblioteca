package com.example.library.dto;

import java.time.LocalDateTime;

public class UserResponseDTO {
    private Long id;
    private String username;
    private String fullName;
    private String role;
    private Boolean enabled;
    private LocalDateTime createdAt;
}