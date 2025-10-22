package com.example.library.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String fullName;
    private Boolean enabled;
    private LocalDateTime createdAt;
}