package com.example.library.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class LoanRequestDTO {
    @NotNull
    private Long bookId;
    @NotNull private Long clientId;
    @NotNull private LocalDate dueDate;
    private Long userId; // opcional
}

