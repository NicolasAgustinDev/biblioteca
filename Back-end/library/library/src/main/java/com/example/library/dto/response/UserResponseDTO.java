package com.example.library.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserResponseDTO {
    private String username;
    private String userFullName;
    private Boolean userEnabled;
    private LocalDateTime userCreatedAt;
}