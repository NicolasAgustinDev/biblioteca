package com.example.library.dto;

import java.time.LocalDate;

public class LoanResponseDTO {
    private Long id;
    private Long bookId;
    private String bookTitle;
    private Long clientId;
    private String clientName;
    private Long userId;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private String status;
}
