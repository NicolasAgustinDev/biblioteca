package com.example.library.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequestDTO {
    @NotNull
    private Long bookId;
    @NotNull
    private Long clientId;
    @NotNull
    private LocalDate dueDate;
    private Long userId;

}
