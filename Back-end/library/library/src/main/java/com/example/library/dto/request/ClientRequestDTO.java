package com.example.library.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientRequestDTO {
        @NotBlank
        private String clientName;
        @Email
        private String clientEmail;
        private String clientPhone;
        private String clientAddress;

}
