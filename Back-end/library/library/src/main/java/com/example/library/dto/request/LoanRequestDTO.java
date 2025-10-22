package com.example.library.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanRequestDTO {
    @NotNull
    private Long bookId;
    @NotNull
    private Long clientEmail;
    @NotNull
    private LocalDate dueDate;
    private Long userId;

}
