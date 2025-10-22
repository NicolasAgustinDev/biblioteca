package com.example.library.dto.response;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
public class LoanResponseDTO {
    private Long loanId;
    private Long bookId;
    private String bookTitle;
    private Long clientId;
    private String clientName;
    private Long userId;
    private LocalDate loanDate; //especificar mejor que se trate de la fecha de ingreso
    private LocalDate loanDueDate;
    private LocalDate loanReturnDate;
    private boolean loanDelivery;
}

