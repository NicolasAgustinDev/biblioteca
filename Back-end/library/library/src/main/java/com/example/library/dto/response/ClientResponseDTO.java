package com.example.library.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ClientResponseDTO {
    private Long clientId;
    private String clientName;
    private String clientEmail;
    private String clientPhone;
    private String clientAddress;
    private LocalDateTime clientCreatedAt;
}
