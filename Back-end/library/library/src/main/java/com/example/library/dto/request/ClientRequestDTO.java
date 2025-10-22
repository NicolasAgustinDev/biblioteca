package com.example.library.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDTO {
        @NotBlank
        private String name;

        @Email
        private String email;
        private String phone;
        private String address;

}
