package com.example.library.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private LocalDateTime createdAt;
}
