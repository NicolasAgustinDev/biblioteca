package com.example.library.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponseDTO {
    // getters y setters
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

