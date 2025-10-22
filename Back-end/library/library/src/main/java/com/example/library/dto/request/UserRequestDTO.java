package com.example.library.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    private Long id;

    @NotBlank
    private String password;
    private String fullName;
    private LocalDateTime createdAt;
}