package com.example.library.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestDTO {
    @NotBlank
    private String username;
    @NotBlank private String userPassword;
    private String userFullName;
}