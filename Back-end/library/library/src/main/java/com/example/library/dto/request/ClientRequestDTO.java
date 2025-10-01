package com.example.library.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClientRequestDTO {
        @NotBlank
        private String name;
        @Email
        private String email;
        private String phone;
        private String address;

}
